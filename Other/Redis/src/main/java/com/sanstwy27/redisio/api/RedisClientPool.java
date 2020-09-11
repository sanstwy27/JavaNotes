package com.sanstwy27.redisio.api;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @author Sanstwy27
 * @create 9/11/2020
 */

public class RedisClientPool {

    private LinkedBlockingQueue<RedisClient> linkedBlockingQueue;

    public RedisClientPool(String host, int port, int connectionCount) {
        this.linkedBlockingQueue = new LinkedBlockingQueue<RedisClient>(10);
        for(int i = 0; i < connectionCount; i++) {
            RedisClient connection = new RedisClient(host, port);
            linkedBlockingQueue.add(connection);
        }
    }

    public RedisClient getClient() {
        try {
            return linkedBlockingQueue.take();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void returnClient(RedisClient client) {
        if(client == null) {
            return;
        }
        try {
            linkedBlockingQueue.put(client);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
