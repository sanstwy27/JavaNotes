package com.sanstwy27.netty.inoutboundhandler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class MyLongToByteEncoder extends MessageToByteEncoder<Long> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, Long aLong, ByteBuf byteBuf) throws Exception {
        System.out.println("MyLongToByteEncoder encode() invoked");
        System.out.println("msg = " + aLong);
        byteBuf.writeLong(aLong);
    }
}
