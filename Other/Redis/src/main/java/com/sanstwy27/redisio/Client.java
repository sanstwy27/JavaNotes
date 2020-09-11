package com.sanstwy27.redisio;

import com.sanstwy27.redisio.api.RedisClientPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author Sanstwy27
 * @create 9/11/2020
 */

public class Client {
    public static void main(String[] args) {
        RedisClientPool clientPool = new RedisClientPool("localhost", 16379, 10);

        ExecutorService pool = Executors.newCachedThreadPool();
        for(int i = 0; i < 20; i++) {
            pool.execute(new ClientRunnable(clientPool, "v" + i));
        }
    }
}
