package com.sanstwy27.blockingqueue.prodconsumer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Sanstwy27
 * @create 8/24/2020
 */

public class ShareDataBlockingQueue {
    private volatile boolean FLAG = true;
    private AtomicInteger atomicInteger = new AtomicInteger();

    private BlockingQueue<String> blockingQueue = null;

    public ShareDataBlockingQueue(BlockingQueue<String> blockingQueue) {
        this.blockingQueue = blockingQueue;
        System.out.println(blockingQueue.getClass().getName());
    }

    public void produce() {
        String data = null;
        boolean retValue;
        while (FLAG) {
            data = atomicInteger.incrementAndGet() + "";
            try {
                retValue = blockingQueue.offer(data,2L, TimeUnit.SECONDS);
                if (retValue) {
                    System.out.println(Thread.currentThread().getName() + "\t enqueue " + data + " success");
                } else {
                    System.out.println(Thread.currentThread().getName() + "\t enqueue " + data + " failed");
                }
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Thread.currentThread().getName() + "\t produce done");
    }

    public void consume() {
        String result = null;
        while (FLAG) {
            try {
                result = blockingQueue.poll(2L, TimeUnit.SECONDS);
                if (null == result || result.equalsIgnoreCase("")) {
                    FLAG = false;
                    System.out.println(Thread.currentThread().getName() + "\t timer expired, ending consumer...");
                    System.out.println();
                    System.out.println();
                    return;
                }
                System.out.println(Thread.currentThread().getName() + "\t consume " + result + " done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void stop() {
        FLAG = false;
        System.out.println("Stop producing process");
    }
}
