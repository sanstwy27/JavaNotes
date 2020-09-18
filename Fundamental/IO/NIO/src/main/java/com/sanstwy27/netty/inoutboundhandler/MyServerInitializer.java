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

public class MyServerInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        ChannelPipeline pipeline = socketChannel.pipeline();

        // inbound handler, MyByteToLongDecoder
        //pipeline.addLast(new MyByteToLongDecoder2());
        pipeline.addLast(new MyByteToLongDecoder());
        // outbound handler, MyLongToByteEncoder
        pipeline.addLast(new MyLongToByteEncoder());
        // custom handler
        pipeline.addLast(new MyServerHandler());

        System.out.println("initChannel done");
    }
}
