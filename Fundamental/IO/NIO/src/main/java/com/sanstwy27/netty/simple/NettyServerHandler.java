package com.sanstwy27.netty.simple;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.channel.ChannelPipeline;
import io.netty.util.CharsetUtil;

/**
 * @author Sanstwy27
 * @create 9/17/2020
 */

public class NettyServerHandler extends ChannelInboundHandlerAdapter {
    /**
     * @param ctx
     * @param msg
     * @throws Exception
     *
     * ChannelHandlerContext ctx = pipeline + channel + address + etc.
     * Object msg = client message
     */
    @Override
    public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {

        /**
         * Async task solution 1 - taskQueue:
         *
         *         ctx.channel().eventLoop().execute(new Runnable() {
         *             @Override
         *             public void run() {
         *
         *                 try {
         *                     Thread.sleep(5 * 1000);
         *                     ctx.writeAndFlush(Unpooled.copiedBuffer("hello, client~(>^ω^<) meow2", CharsetUtil.UTF_8));
         *                     System.out.println("channel code=" + ctx.channel().hashCode());
         *                 } catch (Exception ex) {
         *                     System.out.println("Exception: " + ex.getMessage());
         *                 }
         *             }
         *         });
         *
         * Async task solution 2 - scheduleTaskQueue:
         *
         *         ctx.channel().eventLoop().schedule(new Runnable() {
         *             @Override
         *             public void run() {
         *
         *                 try {
         *                     Thread.sleep(5 * 1000);
         *                     ctx.writeAndFlush(Unpooled.copiedBuffer("hello, client~(>^ω^<) meow3", CharsetUtil.UTF_8));
         *                     System.out.println("channel code=" + ctx.channel().hashCode());
         *                 } catch (Exception ex) {
         *                     System.out.println("Exception: " + ex.getMessage());
         *                 }
         *             }
         *         }, 5, TimeUnit.SECONDS);
         *
         *
         * System.out.println("go on ...");
         */

        System.out.println("server read thread " + Thread.currentThread().getName() + " channle =" + ctx.channel());
        System.out.println("server ctx =" + ctx);
        Channel channel = ctx.channel();
        ChannelPipeline pipeline = ctx.pipeline();

        // Netty ByteBuf (not NIO ByteBuffer)
        ByteBuf buf = (ByteBuf) msg;
        System.out.println("Client message: " + buf.toString(CharsetUtil.UTF_8));
        System.out.println("Client address: " + channel.remoteAddress());
    }

    @Override
    public void channelReadComplete(ChannelHandlerContext ctx) throws Exception {
        ctx.writeAndFlush(Unpooled.copiedBuffer("hello, client~(>^ω^<) meow1", CharsetUtil.UTF_8));
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        ctx.close();
    }
}
