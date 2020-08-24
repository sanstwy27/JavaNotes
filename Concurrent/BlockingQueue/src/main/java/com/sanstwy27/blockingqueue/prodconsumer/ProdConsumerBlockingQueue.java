package com.sanstwy27.blockingqueue.prodconsumer;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author Sanstwy27
 * @create 8/24/2020
 */

public class ProdConsumerBlockingQueue {
    public static void main(String[] args) {
        ShareDataBlockingQueue shareDataBlockingQueue = new ShareDataBlockingQueue(new ArrayBlockingQueue<>(3));

        new Thread(() -> {
            shareDataBlockingQueue.produce();
        }, "Producer").start();

        new Thread(() -> {
            shareDataBlockingQueue.consume();
        }, "Consumer").start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        shareDataBlockingQueue.stop();

        /**
         * java.util.concurrent.ArrayBlockingQueue
         * Producer	 enqueue 1 success
         * Consumer	 consume 1 done
         * Consumer	 consume 2 done
         * Producer	 enqueue 2 success
         * Producer	 enqueue 3 success
         * Consumer	 consume 3 done
         * Consumer	 consume 4 done
         * Producer	 enqueue 4 success
         * Producer	 enqueue 5 success
         * Consumer	 consume 5 done
         * Stop producing process
         * Producer	 produce done
         * Consumer	 timer expired, ending consumer...
         */
    }
}
