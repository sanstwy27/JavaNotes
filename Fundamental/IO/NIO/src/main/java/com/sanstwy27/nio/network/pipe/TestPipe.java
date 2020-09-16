package com.sanstwy27.nio.network.pipe;

import org.junit.Test;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

/**
 * @author Sanstwy27
 * @create 9/15/2020
 */

public class TestPipe {
    @Test
    public void pipe()throws IOException {
        Pipe pipe=Pipe.open();

        // Write
        ByteBuffer buf = ByteBuffer.allocate(1024);
        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("Hello, World".getBytes());
        buf.flip();
        sinkChannel.write(buf);

        // Read
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(), 0, len));

        sourceChannel.close();
        sinkChannel.close();
    }
}
