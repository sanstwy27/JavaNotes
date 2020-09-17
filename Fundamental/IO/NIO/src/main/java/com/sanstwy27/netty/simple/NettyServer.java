package com.sanstwy27.netty.simple;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

/**
 * @author Sanstwy27
 * @create 9/17/2020
 */

public class NettyServer {
    private static final int port = 9898;

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        // default = cpu processor * 2
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap bootstrap = new ServerBootstrap();

            // initial
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    // It's a passed through socket option determining the number of connections queued.
                    // The maximum queue length for incoming connection indications (a request to connect) is set to the backlog parameter.
                    // If a connection indication arrives when the queue is full, the connection is refused.
                    .option(ChannelOption.SO_BACKLOG, 128)
                    .childOption(ChannelOption.SO_KEEPALIVE, true)
                    // handler for bossGroup, childHandler for workerGroup
                    //.handler(null)
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        @Override
                        protected void initChannel(SocketChannel ch) throws Exception {
                            // we can menage SocketChannel by set or map，
                            // and forward message to NIOEventLoop taskQueue or scheduleTaskQueue of specific channel

                            System.out.println("client socket channel hashcode=" + ch.hashCode());
                            // add pipeline EventLoop handler in workerGroup
                            ch.pipeline().addLast(new NettyServerHandler());
                        }
                    });

            System.out.println(".....server is ready...");

            ChannelFuture cf = bootstrap.bind(port).sync();
            cf.addListener(new ChannelFutureListener() {
                @Override
                public void operationComplete(ChannelFuture future) throws Exception {
                    if (cf.isSuccess()) {
                        System.out.println("bind " + port + " success");
                    } else {
                        System.out.println("bind " + port + " failure");
                    }
                }
            });

            cf.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
