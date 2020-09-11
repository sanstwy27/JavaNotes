package com.sanstwy27.redisio;

import com.sanstwy27.redisio.api.RedisClient;
import com.sanstwy27.redisio.api.RedisClientPool;

/**
 * @author Sanstwy27
 * @create 9/11/2020
 */

public class ClientRunnable implements Runnable {
    private RedisClientPool pool;
    private String value;

    public ClientRunnable(RedisClientPool pool, String value) {
        this.pool = pool;
        this.value = value;
    }

    @Override
    public void run() {
        RedisClient client = pool.getClient();
        client.set("ant", value);
        pool.returnClient(client);
    }
}
