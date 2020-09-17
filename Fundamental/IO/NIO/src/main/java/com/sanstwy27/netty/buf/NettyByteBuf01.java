package com.sanstwy27.netty.buf;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

/**
 * ByteBuf:
 * 0  <=  readerIndex  <=  writerIndex  <=  capacity
 *
 */
public class NettyByteBuf01 {
    public static void main(String[] args) {
        ByteBuf buffer = Unpooled.buffer(10);

        for (int i = 0; i < 10; i++) {
            buffer.writeByte(i);
        }

        System.out.println("capacity = " + buffer.capacity());

        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.getByte(i));
        }
        System.out.println("readerIndex = " + buffer.readerIndex());

        for (int i = 0; i < buffer.capacity(); i++) {
            System.out.println(buffer.readByte());
        }
        System.out.println("readerIndex = " + buffer.readerIndex());

        System.out.println("done");

        /**
         * capacity = 10
         * 0
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         * readerIndex = 0
         * 0
         * 1
         * 2
         * 3
         * 4
         * 5
         * 6
         * 7
         * 8
         * 9
         * readerIndex = 10
         * done
         */
    }
}
