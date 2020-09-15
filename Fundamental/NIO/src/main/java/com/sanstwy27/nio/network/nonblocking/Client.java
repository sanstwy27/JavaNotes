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
public class Client {
    // Client
    public static void main(String[] args) throws IOException {
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9898));
        // non-blocking
        sChannel.configureBlocking(false);
        ByteBuffer buf = ByteBuffer.allocate(1024);
        // send
        Scanner scan = new Scanner(System.in);
        while (scan.hasNext()) {
            String str = scan.next();
            buf.put((new Date().toString() + "\n" + str).getBytes());
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        sChannel.close();
    }
}
