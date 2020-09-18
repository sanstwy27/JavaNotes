package com.sanstwy27.netty.dubborpc.provider;

import com.sanstwy27.netty.dubborpc.publicinterface.HelloService;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
        System.out.println("msg = " + msg);

        // Custom protocol
        // parameter = "HelloService#hello#...."
        if (msg.toString().startsWith(HelloService.protocolName)) {
            String result = new HelloServiceImpl().hello(msg.toString().substring(msg.toString().lastIndexOf("#") + 1));
            ctx.writeAndFlush(result);
        }
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
