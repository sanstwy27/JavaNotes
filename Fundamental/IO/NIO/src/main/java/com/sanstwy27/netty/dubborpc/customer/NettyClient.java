package com.sanstwy27.netty.dubborpc.customer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioSocketChannel;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.codec.string.StringEncoder;

import java.lang.reflect.Proxy;
import java.util.concurrent.*;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class NettyClient {

    private static final int port = 9898;
    private static NettyClientHandler client;
    private int count = 0;

//    private static ExecutorService executor = new ThreadPoolExecutor(
//            Runtime.getRuntime().availableProcessors(),
//            Runtime.getRuntime().availableProcessors() * 2,
//            2L,
//            TimeUnit.SECONDS,
//            new LinkedBlockingQueue<Runnable>(Runtime.getRuntime().availableProcessors() * 2),
//            Executors.defaultThreadFactory(),
//            new ThreadPoolExecutor.AbortPolicy());
    private static ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());

    public Object getBean(final Class<?> serivceClass, final String providerName) {
        return Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
                new Class<?>[]{serivceClass}, (proxy, method, args) -> {
                    System.out.println("(proxy, method, args) invoke...." + (++count) + " times");

                    if (client == null) {
                        initClient();
                    }

                    // api hello($message) to server
                    // $message = providerName(custom protocol header) + args[0]
                    client.setPara(providerName + args[0]);

                    return executor.submit(client).get();
                });
    }

    private static void initClient() {
        client = new NettyClientHandler();

        NioEventLoopGroup group = new NioEventLoopGroup();
        Bootstrap bootstrap = new Bootstrap();
        bootstrap.group(group)
                .channel(NioSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY, true)
                .handler(
                        new ChannelInitializer<SocketChannel>() {
                            @Override
                            protected void initChannel(SocketChannel ch) throws Exception {
                                ChannelPipeline pipeline = ch.pipeline();
                                pipeline.addLast(new StringDecoder());
                                pipeline.addLast(new StringEncoder());
                                pipeline.addLast(client);
                            }
                        }
                );

        try {
            bootstrap.connect("127.0.0.1", port).sync();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
