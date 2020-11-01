package com.sanstwy27.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import java.nio.charset.Charset;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class NettyByteBuf02 {
    public static void main(String[] args) {
        ByteBuf byteBuf = Unpooled.copiedBuffer("hello,world!", Charset.forName("utf-8"));

        if (byteBuf.hasArray()) {

            byte[] content = byteBuf.array();

            System.out.println(new String(content, Charset.forName("utf-8")));

            System.out.println("byteBuf = " + byteBuf);

            System.out.println(byteBuf.arrayOffset());
            System.out.println(byteBuf.readerIndex());
            System.out.println(byteBuf.writerIndex());
            System.out.println(byteBuf.capacity());

            //System.out.println(byteBuf.readByte());
            System.out.println(byteBuf.getByte(0));

            int len = byteBuf.readableBytes();
            System.out.println("len = " + len);

            for (int i = 0; i < len; i++) {
                System.out.println((char) byteBuf.getByte(i));
            }

            System.out.println(byteBuf.getCharSequence(0, 4, Charset.forName("utf-8")));
            System.out.println(byteBuf.getCharSequence(4, 6, Charset.forName("utf-8")));

            /**
             * hello,world!
             * byteBuf = UnpooledByteBufAllocator$InstrumentedUnpooledUnsafeHeapByteBuf(ridx: 0, widx: 12, cap: 64)
             * 0
             * 0
             * 12
             * 64
             * 104
             * len = 12
             * h
             * e
             * l
             * l
             * o
             * ,
             * w
             * o
             * r
             * l
             * d
             * !
             * hell
             * o,worl
             *
             */
        }
    }
}
