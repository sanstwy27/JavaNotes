package com.sanstwy27.threadpool;

import java.util.concurrent.*;

public class MyThreadPoolApplication {

    public static void main(String[] args) {
        // Custom Pool
        ExecutorService threadPool = new ThreadPoolExecutor(2,
                5,
                1L,
                TimeUnit.SECONDS,
                new LinkedBlockingDeque<Runnable>(3),
                Executors.defaultThreadFactory(),
                //new ThreadPoolExecutor.AbortPolicy());
                //new ThreadPoolExecutor.CallerRunsPolicy());
                //new ThreadPoolExecutor.DiscardOldestPolicy());
                new ThreadPoolExecutor.DiscardPolicy());

        try {
            for (int i = 1; i <= 9; i++) {
                threadPool.execute(() -> {
                    System.out.println(Thread.currentThread().getName() + "\t execute()");
                });
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            threadPool.shutdown();
        }

        /**
         * ---- ThreadPoolExecutor.AbortPolicy() ----
         *
         * java.util.concurrent.RejectedExecutionException: Task com.sanstwy27.threadpool.MyThreadPoolApplication$$Lambda$19/0x0000000800b96440@433c675d rejected from java.util.concurrent.ThreadPoolExecutor@3f91beef[Running, pool size = 5, active threads = 5, queued tasks = 3, completed tasks = 0]
         * 	at java.base/java.util.concurrent.ThreadPoolExecutor$AbortPolicy.rejectedExecution(ThreadPoolExecutor.java:2057)
         * 	at java.base/java.util.concurrent.ThreadPoolExecutor.reject(ThreadPoolExecutor.java:827)
         * 	at java.base/java.util.concurrent.ThreadPoolExecutor.execute(ThreadPoolExecutor.java:1357)
         * 	at com.sanstwy27.threadpool.MyThreadPoolApplication.main(MyThreadPoolApplication.java:19)
         * pool-1-thread-3	 execute()
         * pool-1-thread-3	 execute()
         * pool-1-thread-3	 execute()
         * pool-1-thread-3	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-4	 execute()
         * pool-1-thread-5	 execute()
         * pool-1-thread-1	 execute()
         */

        /**
         * ---- ThreadPoolExecutor.CallerRunsPolicy() ----
         *
         * pool-1-thread-5	 execute()
         * pool-1-thread-5	 execute()
         * pool-1-thread-5	 execute()
         * pool-1-thread-5	 execute()
         * main	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-3	 execute()
         * pool-1-thread-4	 execute()
         * pool-1-thread-1	 execute()
         *
         */

        /**
         * ---- ThreadPoolExecutor.DiscardOldestPolicy() ----
         *
         * pool-1-thread-1	 execute()
         * pool-1-thread-4	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-3	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-4	 execute()
         * pool-1-thread-5	 execute()
         * pool-1-thread-1	 execute()
         */

        /**
         * ---- ThreadPoolExecutor.DiscardPolicy() ----
         *
         * pool-1-thread-3	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-4	 execute()
         * pool-1-thread-5	 execute()
         * pool-1-thread-1	 execute()
         * pool-1-thread-2	 execute()
         * pool-1-thread-3	 execute()
         */
    }

}
