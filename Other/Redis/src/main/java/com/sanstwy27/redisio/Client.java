package com.sanstwy27.redisio;

import com.sanstwy27.redisio.api.RedisClientPool;

import java.util.concurrent.*;

/**
 * @author Sanstwy27
 * @create 9/11/2020
 */

public class Client {
    public static void main(String[] args) {
        RedisClientPool clientPool = new RedisClientPool("localhost", 16379, 10);

        ExecutorService pool = new ThreadPoolExecutor(10,
                15,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(5000000),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.DiscardPolicy());
        try {
            for (int i = 0; i < 10000000; i++) {
                pool.execute(new ClientRunnable(clientPool, "v" + i));
            }
        } finally {
            pool.shutdown();
        }

        Thread.yield();
    }
}
