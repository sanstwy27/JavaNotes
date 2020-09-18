package com.sanstwy27.netty.inoutboundhandler;

import com.sanstwy27.netty.inoutboundhandler.codec.MyByteToLongDecoder;
import com.sanstwy27.netty.inoutboundhandler.codec.MyByteToLongDecoder2;
import com.sanstwy27.netty.inoutboundhandler.codec.MyLongToByteEncoder;
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
        // outbound handler
        pipeline.addLast(new MyLongToByteEncoder());
        // inbound handler
        //pipeline.addLast(new MyByteToLongDecoder2());
        pipeline.addLast(new MyByteToLongDecoder());
        // custom handler
        pipeline.addLast(new MyClientHandler());
    }
}
