package com.sanstwy27.netty.tcp.separate;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.nio.charset.Charset;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class MyClientHandler extends SimpleChannelInboundHandler<MessageProtocol> {
    private int count;

    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, MessageProtocol msg) throws Exception {
        int len = msg.getLen();
        byte[] content = msg.getContent();

        System.out.println("[Client] recv...");
        System.out.println("len = " + len);
        System.out.println("content = " + new String(content, Charset.forName("utf-8")));
        System.out.println("received message count = " + (++this.count));
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        for (int i = 0; i < 5; i++) {
            String msg = "0xCAFE 0xBABE";
            byte[] content = msg.getBytes(Charset.forName("utf-8"));
            int length = msg.getBytes(Charset.forName("utf-8")).length;

            MessageProtocol messageProtocol = new MessageProtocol();
            messageProtocol.setLen(length);
            messageProtocol.setContent(content);
            ctx.writeAndFlush(messageProtocol);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        System.out.println("Exception = " + cause.getMessage());
        ctx.close();
    }
}
