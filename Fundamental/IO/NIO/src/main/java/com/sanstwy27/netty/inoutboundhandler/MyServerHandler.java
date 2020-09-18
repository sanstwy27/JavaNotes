package com.sanstwy27.netty.inoutboundhandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class MyServerHandler extends SimpleChannelInboundHandler<Long> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Long aLong) throws Exception {
        System.out.println("recv from client[" + ctx.channel().remoteAddress() + "], msg [" + aLong + "]");

        ctx.writeAndFlush(98765L);
    }
}
