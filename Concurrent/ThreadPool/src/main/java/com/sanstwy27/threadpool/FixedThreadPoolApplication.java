package com.sanstwy27.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FixedThreadPoolApplication {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);

        for (int i = 1; i <= 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t execute()");
            });
        }

        /**
         * pool-1-thread-1	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-5	 execute()
         * pool-1-thread-4	 execute()
         * pool-1-thread-3	 execute()
         */
    }

}
