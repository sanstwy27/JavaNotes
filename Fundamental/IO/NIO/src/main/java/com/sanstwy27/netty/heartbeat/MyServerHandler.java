package com.sanstwy27.netty.heartbeat;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.handler.timeout.IdleStateEvent;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class MyServerHandler extends ChannelInboundHandlerAdapter {
    @Override
    public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
        if(evt instanceof IdleStateEvent) {
            IdleStateEvent event = (IdleStateEvent) evt;
            String eventType = null;
            switch (event.state()) {
                case READER_IDLE:
                    eventType = "read idle";
                    break;
                case WRITER_IDLE:
                    eventType = "write idle";
                    break;
                case ALL_IDLE:
                    eventType = "read-write idle";
                    break;
            }
            System.out.println(ctx.channel().remoteAddress() + " --IdleState-- " + eventType);
            System.out.println("Server handling..");

            // TODO
            // Do Something, ex:
            // ctx.channel().close();
        }
    }
}
