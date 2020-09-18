package com.sanstwy27.netty.inoutboundhandler.codec;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

/**
 * The biggest difference between ReplayingDecoder and ByteToMessageDecoder is that
 * ReplayingDecoder allows you to implement the decode() and decodeLast() methods
 * just like all required bytes were received already,
 * rather than checking the availability of the required bytes
 */
public class MyByteToLongDecoder2 extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyByteToLongDecoder2 decode() invoked");

        out.add(in.readLong());
    }
}
