package com.sanstwy27.netty.dubborpc.provider;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class ServerBootstrap {
    public static void main(String[] args) {
        NettyServer.startServer("127.0.0.1", 9898);
    }
}
