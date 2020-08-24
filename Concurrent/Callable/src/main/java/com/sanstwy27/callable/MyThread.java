package com.sanstwy27.callable;

import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * @author Sanstwy27
 * @create 8/24/2020
 */

public class MyThread implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        System.out.println(Thread.currentThread().getName() + "\t **** come in Callable");
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) { e.printStackTrace(); }
        return 1024;
    }
}
