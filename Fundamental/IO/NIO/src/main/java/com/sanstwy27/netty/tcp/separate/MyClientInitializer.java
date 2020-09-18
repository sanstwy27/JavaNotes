package com.sanstwy27.netty.tcp.separate;

import com.sanstwy27.netty.tcp.separate.codec.MyMessageDecoder;
import com.sanstwy27.netty.tcp.separate.codec.MyMessageEncoder;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class MyClientInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new MyMessageEncoder());
        pipeline.addLast(new MyMessageDecoder());
        pipeline.addLast(new MyClientHandler());
    }
}
