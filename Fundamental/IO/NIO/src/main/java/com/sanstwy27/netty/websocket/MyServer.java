package com.sanstwy27.netty.websocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class MyServer {
    private static final int port = 9898;
    private static final String wsPath = "/hello";

    public static void main(String[] args) throws InterruptedException {
        EventLoopGroup bossGroup = new NioEventLoopGroup(1);
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();

            serverBootstrap.group(bossGroup, workerGroup);
            serverBootstrap.channel(NioServerSocketChannel.class);
            serverBootstrap.handler(new LoggingHandler(LogLevel.INFO));
            serverBootstrap.childHandler(new ChannelInitializer<SocketChannel>() {
                @Override
                protected void initChannel(SocketChannel ch) throws Exception {
                    ChannelPipeline pipeline = ch.pipeline();

                    // http coder, decoder
                    pipeline.addLast(new HttpServerCodec());
                    pipeline.addLast(new ChunkedWriteHandler());
                    // A ChannelHandler that aggregates an HttpMessage and its following HttpContents
                    // into a single FullHttpRequest or FullHttpResponse
                    // (depending on if it used to handle requests or responses) with no following HttpContents.
                    pipeline.addLast(new HttpObjectAggregator(8192));

                    // websocket
                    // 1. transfer by frame
                    // 2. uri = ws://ip:port/path
                    // 3. WebSocketServerProtocolHandler uprate http protocol to ws protocol
                    // 4. status code 101
                    pipeline.addLast(new WebSocketServerProtocolHandler(wsPath));
                    pipeline.addLast(new MyTextWebSocketFrameHandler());
                }
            });

            ChannelFuture channelFuture = serverBootstrap.bind(port).sync();
            channelFuture.channel().closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
