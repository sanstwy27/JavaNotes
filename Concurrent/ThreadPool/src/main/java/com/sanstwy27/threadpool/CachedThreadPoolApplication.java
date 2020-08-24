package com.sanstwy27.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CachedThreadPoolApplication {

    public static void main(String[] args) {
        // Dynamic Pool
        ExecutorService threadPool = Executors.newCachedThreadPool();

        // 1. No sleep
        for (int i = 1; i <= 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t execute()");
            });
        }

        /**
         * pool-1-thread-7	 execute()
         * pool-1-thread-3	 execute()
         * pool-1-thread-4	 execute()
         * pool-1-thread-9	 execute()
         * pool-1-thread-6	 execute()
         * pool-1-thread-10	 execute()
         * pool-1-thread-5	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-8	 execute()
         * pool-1-thread-2	 execute()
         */

        // cool down ...
        System.out.println();
        System.out.println();
        try {
            TimeUnit.MILLISECONDS.sleep(2000);
        } catch (InterruptedException e) { e.printStackTrace(); }
        System.out.println();
        System.out.println();

        // 2. Sleep
        for (int i = 1; i <= 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t execute()");
            });
            try {
                TimeUnit.MILLISECONDS.sleep(200);
            } catch (InterruptedException e) { e.printStackTrace(); }
        }

        /**
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         */
    }

}
