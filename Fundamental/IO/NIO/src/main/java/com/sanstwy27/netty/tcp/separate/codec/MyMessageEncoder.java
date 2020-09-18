package com.sanstwy27.netty.tcp.separate.codec;

import com.sanstwy27.netty.tcp.separate.MessageProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class MyMessageEncoder extends MessageToByteEncoder<MessageProtocol> {
    @Override
    protected void encode(ChannelHandlerContext channelHandlerContext, MessageProtocol msg, ByteBuf out) throws Exception {
        System.out.println("MyMessageEncoder encode() invoked.");
        out.writeInt(msg.getLen());
        out.writeBytes(msg.getContent());
    }
}
