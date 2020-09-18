package com.sanstwy27.netty.inoutboundhandler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;

import java.util.List;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class MyByteToLongDecoder extends ByteToMessageDecoder {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder decode() invoked");

        if(in.readableBytes() >= 8) {
            out.add(in.readLong());
        }
    }
}
