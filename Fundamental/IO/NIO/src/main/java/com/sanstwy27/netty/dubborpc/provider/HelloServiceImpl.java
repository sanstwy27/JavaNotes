package com.sanstwy27.netty.dubborpc.provider;

import com.sanstwy27.netty.dubborpc.publicinterface.HelloService;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class HelloServiceImpl implements HelloService {
    private static int count = 0;

    @Override
    public String hello(String msg) {
        System.out.println("recv client message = " + msg);

        if(msg != null) {
            return "Hello, i have received your message[" + msg + "]... invoke [" + (++count) + "] times";
        } else {
            return "Hello, i have received your message ";
        }
    }
}
