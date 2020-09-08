package com.sanstwy27.zookeeper.distributedlock;

import com.sanstwy27.zookeeper.distributedlock.util.OrderNumberCreateUtil;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.locks.InterProcessMutex;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.util.concurrent.TimeUnit;

/**
 * @author Sanstwy27
 * @create 9/8/2020
 * @Reference
 *   1. Zookeeper
 *     - Zookeeper in Docker https://www.cnblogs.com/LUA123/p/11428113.html
 *     - ZooInspector https://www.cnblogs.com/lwcode6/p/11586537.html
 *   2. Demo
 *     - http://www.mydlq.club/article/67/#wow13
 *     - https://stackoverflow.com/questions/46617044/
 */

@SpringBootApplication
public class Client {
    @Autowired
    CuratorFramework curatorFramework;

    private OrderNumberCreateUtil orderNumberCreateUtil = new OrderNumberCreateUtil();

    @PostConstruct
    public void test() {
        int threadCount = 1000;
        for (int i = 0; i < threadCount; i++) {
            new Thread(() -> {
                try {
                    InterProcessMutex interProcessMutex = new InterProcessMutex(curatorFramework, "/lock-space");
                    while (!interProcessMutex.isAcquiredInThisProcess()) {
                        interProcessMutex.acquire(25, TimeUnit.SECONDS);
                    }
                    System.out.println(orderNumberCreateUtil.getOrderNumber());
                    interProcessMutex.release();
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }).start();
        }
    }

    public static void main(String[] args) {
        SpringApplication.run(Client.class, args);
    }
}
