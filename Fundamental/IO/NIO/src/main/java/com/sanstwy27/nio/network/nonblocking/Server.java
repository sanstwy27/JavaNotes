package com.sanstwy27.nio.network.nonblocking;

/**
 * @author Sanstwy27
 * @create 9/15/2020
 */

import org.junit.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;

/**
 * 1、Channel for connection:
 *      java.nio.channels.Channel interface：
 *           |--SelectableChannel
 *               |--SocketChannel
 *               |--ServerSocketChannel
 *               |--DatagramChannel
 *
 *               |--Pipe.SinkChannel
 *               |--Pipe.SourceChannel
 *
 * 2. Buffer
 * 3. Selector:
 *     A selector provides a mechanism for monitoring one or more NIO channels and recognizing
 *     when one or more become available for data transfer.
 *     This way, a single thread can be used for managing multiple channels,
 *     and thus multiple network connections.
 *
 * Why Use a Selector?
 * With a selector, we can use one thread instead of several to manage multiple channels. Context-switching between threads is expensive for the operating system, and additionally, each thread takes up memory.
 * Therefore, the fewer threads we use, the better. However, it's important to remember that modern operating systems and CPU's keep getting better at multitasking, so the overheads of multi-threading keep diminishing over time.
 * We'll be dealing with here is how we can handle multiple channels with a single thread using a selector.
 * Note also that selectors don't just help you read data; they can also listen for incoming network connections and write data across slow channels.
 * ref: https://www.baeldung.com/java-nio-selector
 */
public class Server {
    // Server
    public static void main(String[] args) throws IOException {
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        // non-blocking
        ssChannel.configureBlocking(false);
        ssChannel.bind(new InetSocketAddress(9898));

        Selector selector = Selector.open();

        // Registering Selectable Channels
        //   In order for a selector to monitor any channels,
        //   we must register these channels with the selector.
        //   We do this by invoking the register method of the selectable channel.
        ssChannel.register(selector, SelectionKey.OP_ACCEPT);
        while (selector.select() > 0) {
            Iterator<SelectionKey> it = selector.selectedKeys().iterator();
            while (it.hasNext()) {
                SelectionKey sk = it.next();
                if (sk.isAcceptable()) {
                    SocketChannel sChannel = ssChannel.accept();
                    sChannel.configureBlocking(false);
                    sChannel.register(selector, SelectionKey.OP_READ);
                } else if (sk.isReadable()) {
                    SocketChannel sChannel = (SocketChannel) sk.channel();
                    // Recv
                    ByteBuffer buf = ByteBuffer.allocate(1024);
                    int len = 0;
                    while ((len = sChannel.read(buf)) > 0) {
                        buf.flip();
                        System.out.println(new String(buf.array(), 0, len));
                        buf.clear();
                    }
                }
                // remove SelectionKey
                it.remove();
            }
        }
    }
}
