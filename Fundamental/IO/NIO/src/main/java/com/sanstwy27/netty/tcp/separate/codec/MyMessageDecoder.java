package com.sanstwy27.netty.tcp.separate.codec;

import com.sanstwy27.netty.tcp.separate.MessageProtocol;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ReplayingDecoder;

import java.util.List;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class MyMessageDecoder extends ReplayingDecoder<Void> {
    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf in, List<Object> out) throws Exception {
        System.out.println("MyMessageDecoder decode() invoked.");

        // MessageProtocol Frame (Object)
        int length = in.readInt();
        byte[] content = new byte[length];
        in.readBytes(content);

        // construct MessageProtocol obj，and pass to next handler
        MessageProtocol messageProtocol = new MessageProtocol();
        messageProtocol.setLen(length);
        messageProtocol.setContent(content);

        out.add(messageProtocol);
    }
}
