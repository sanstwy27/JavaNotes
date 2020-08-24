package com.sanstwy27.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SingleThreadPoolApplication {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newSingleThreadExecutor();

        for (int i = 1; i <= 10; i++) {
            threadPool.execute(() -> {
                System.out.println(Thread.currentThread().getName() + "\t execute()");
            });
        }

        /**
         * pool-1-thread-1	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-1	 execute()
         */
    }

}
