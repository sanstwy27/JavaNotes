package com.sanstwy27.netty.dubborpc.customer;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

import java.util.concurrent.Callable;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class NettyClientHandler extends ChannelInboundHandlerAdapter implements Callable {
    private ChannelHandlerContext context;
    // RPC result
    private String result;
    // RPC parameter string
    private String para;

    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        System.out.println(" channelActive invoked  ");
        context = ctx;
    }

    @Override
    public synchronized void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println(" channelRead invoked  ");
        result = msg.toString();
        notify();
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }

    @Override
    public synchronized Object call() throws Exception {
        System.out.println(" call invoked  ");
        context.writeAndFlush(para);
        System.out.println(" call rpc... wait  ");
        wait();
        System.out.println(" call rpc... done  ");
        return result;
    }

    public void setPara(String para) {
        System.out.println(" setPara  ");
        this.para = para;
    }
}
