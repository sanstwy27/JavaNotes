package com.sanstwy27.netty.http;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.handler.codec.http.*;
import io.netty.util.CharsetUtil;

import java.net.URI;

/**
 * @author Sanstwy27
 * @create 9/17/2020
 */

public class TestHttpServerHandler extends SimpleChannelInboundHandler<HttpObject> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, HttpObject httpObject) throws Exception {
        System.out.println(
                " channel = " + ctx.channel() +
                " pipeline = " + ctx.pipeline() +
                " pipeline channel = " + ctx.pipeline().channel());

        System.out.println(" context handler = " + ctx.handler());

        Object msg = httpObject;
        if (msg instanceof HttpRequest) {
            System.out.println("context type = " + ctx.getClass());
            System.out.println("pipeline hashcode = " + ctx.pipeline().hashCode() + ", TestHttpServerHandler hash = " + this.hashCode());
            System.out.println("msg type = " + msg.getClass());
            System.out.println("client address = " + ctx.channel().remoteAddress());

            HttpRequest httpRequest = (HttpRequest) msg;
            URI uri = new URI(httpRequest.uri());

            if ("/favicon.ico".equals(uri.getPath())) {
                System.out.println("ignore favicon.ico request");
                return;
            }

            // http response [http protocol]
            ByteBuf content = Unpooled.copiedBuffer("hello, I'm server", CharsetUtil.UTF_8);
            FullHttpResponse response = new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.OK, content);
            response.headers().set(HttpHeaderNames.CONTENT_TYPE, "text/plain");
            response.headers().set(HttpHeaderNames.CONTENT_LENGTH, content.readableBytes());

            ctx.writeAndFlush(response);
        }
    }
}
