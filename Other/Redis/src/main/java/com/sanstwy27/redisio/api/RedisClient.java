package com.sanstwy27.redisio.api;

import com.sanstwy27.redisio.connection.Connection;
import com.sanstwy27.redisio.protocol.Protocol;

/**
 * @author Sanstwy27
 * @create 9/11/2020
 */

public class RedisClient {

    private Connection connection;

    public RedisClient(String host, int port) {
        connection = new Connection(host, port);
    }

    public String set(String key, String value) {
        String result = connection.sendCommand(
                Protocol.buildRespByte(Protocol.Command.SET, key.getBytes(), value.getBytes())
        );
        System.out.println("Thread name:" + Thread.currentThread().getName() +
                " [result]:" + result.replace("\r\n", "") +
                " [value]:" + value);
        return result;
    }

    public String get(String key) {
        String result = connection.sendCommand(
                Protocol.buildRespByte(Protocol.Command.GET, key.getBytes())
        );
        return result;
    }
}
