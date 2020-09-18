package com.sanstwy27.netty.dubborpc.publicinterface;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public interface HelloService {
    String protocolName = "HelloService#hello#";
    String hello(String mes);
}
