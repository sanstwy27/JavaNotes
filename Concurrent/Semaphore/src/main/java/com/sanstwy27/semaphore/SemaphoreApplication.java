package com.sanstwy27.semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

public class SemaphoreApplication {

    public static void main(String[] args) {
        int count = 3;
        Semaphore semaphore = new Semaphore(count);

        for (int i = 1; i <= 6; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName() + " acquires a parking space.");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println(Thread.currentThread().getName() + " releases a parking space after 3 seconds.");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    semaphore.release();
                }
            }, String.valueOf(i)).start();
        }

        /**
         * 1 acquires a parking space.
         * 4 acquires a parking space.
         * 3 acquires a parking space.
         * 4 releases a parking space after 3 seconds.
         * 1 releases a parking space after 3 seconds.
         * 2 acquires a parking space.
         * 5 acquires a parking space.
         * 3 releases a parking space after 3 seconds.
         * 6 acquires a parking space.
         * 2 releases a parking space after 3 seconds.
         * 5 releases a parking space after 3 seconds.
         * 6 releases a parking space after 3 seconds.
         */
    }

}
