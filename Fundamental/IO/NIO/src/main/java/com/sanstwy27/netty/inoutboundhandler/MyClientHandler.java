package com.sanstwy27.netty.inoutboundhandler;

import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.util.CharsetUtil;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class MyClientHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext channelHandlerContext, Long aLong) throws Exception {
        System.out.println("Server ip = " + channelHandlerContext.channel().remoteAddress());
        System.out.println("Server message = " + aLong);
    }

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println("MyClientHandler send");
        ctx.writeAndFlush(Unpooled.copiedBuffer("abcdefghijklmnopqrstuvwxyz", CharsetUtil.UTF_8));
        //ctx.writeAndFlush(123L);
    }
}
