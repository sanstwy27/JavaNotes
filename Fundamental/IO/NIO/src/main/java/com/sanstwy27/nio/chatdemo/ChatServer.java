package com.sanstwy27.nio.chatdemo;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @author Sanstwy27
 * @create 9/17/2020
 */

public class ChatServer {
    private Selector selector;
    private ServerSocketChannel listenChannel;
    private static final int PORT = 9898;

    public ChatServer() {
        try {
            selector = Selector.open();
            //ServerSocketChannel
            listenChannel = ServerSocketChannel.open();
            listenChannel.socket().bind(new InetSocketAddress(PORT));
            listenChannel.configureBlocking(false);
            listenChannel.register(selector, SelectionKey.OP_ACCEPT);

        } catch (IOException e) {
            e.printStackTrace();
        }
        return;
    }

    public void listen() {
        System.out.println("listen: " + Thread.currentThread().getName());
        try {
            while (true) {

                int count = selector.select();
                if (count > 0) {
                    Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
                    while (iterator.hasNext()) {

                        SelectionKey key = iterator.next();

                        if (key.isAcceptable()) {
                            SocketChannel sc = listenChannel.accept();
                            sc.configureBlocking(false);
                            sc.register(selector, SelectionKey.OP_READ);
                            System.out.println(sc.getRemoteAddress() + " online ");
                        }
                        if (key.isReadable()) {
                            MyHandler.readData(key, selector);
                        }
                        // remove current selectionKey
                        iterator.remove();
                    }

                } else {
                    System.out.println("waiting....");
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // TODO
        }
    }

    public static void main(String[] args) {
        ChatServer groupChatServer = new ChatServer();
        groupChatServer.listen();
    }
}

class MyHandler {
    public static void readData(SelectionKey key, Selector selector) {
        SocketChannel channel = null;

        try {
            channel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);

            int count = channel.read(buffer);
            if (count > 0) {
                String msg = new String(buffer.array());
                System.out.println("Client msg : " + msg);
                sendInfoToOtherClients(msg, channel, selector);
            }
        } catch (IOException e) {
            try {
                System.out.println(channel.getRemoteAddress() + " offline..");
                key.cancel();
                channel.close();
            } catch (IOException e2) {
                e2.printStackTrace();
                ;
            }
        }
    }

    public static void sendInfoToOtherClients(String msg, SocketChannel self, Selector selector) throws IOException {
        System.out.println("Forwarding message...");
        System.out.println("Thread : " + Thread.currentThread().getName());
        for (SelectionKey key : selector.keys()) {
            Channel targetChannel = key.channel();
            if (targetChannel instanceof SocketChannel && targetChannel != self) {
                SocketChannel dest = (SocketChannel) targetChannel;
                ByteBuffer buffer = ByteBuffer.wrap(msg.getBytes());
                dest.write(buffer);
            }
        }
    }
}