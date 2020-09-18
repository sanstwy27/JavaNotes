package com.sanstwy27.netty.dubborpc.customer;

import com.sanstwy27.netty.dubborpc.publicinterface.HelloService;

/**
 * @author Sanstwy27
 * @create 9/18/2020
 */

public class ClientBootstrap {
    public static void main(String[] args) throws InterruptedException {
        NettyClient customer = new NettyClient();

        HelloService service = (HelloService) customer.getBean(HelloService.class, HelloService.protocolName);

        for (;;) {
            Thread.sleep(2 * 1000);
            // invoke rpc with proxy object
            String res = service.hello("hello, dubbo~");
            System.out.println("result = " + res);
        }
    }
}
