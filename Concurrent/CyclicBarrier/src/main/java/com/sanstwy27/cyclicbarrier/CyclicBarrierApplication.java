package com.sanstwy27.cyclicbarrier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierApplication {

    public static void main(String[] args) {
        int count = 7;
        // CyclicBarrier(int parties, Runnable barrierAction)
        CyclicBarrier cyclicBarrier = new CyclicBarrier(count, () -> {System.out.println("project done.");});

        for(int i = 1; i <= 7; i++) {
            final  int tempInt = i;
            new Thread(() -> {
               System.out.println(Thread.currentThread().getName() + "\t task done.");
                try {
                    cyclicBarrier.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } catch (BrokenBarrierException e) {
                    e.printStackTrace();
                }
            }, String.valueOf(i)).start();
        }

        /**
         * 7	 task done.
         * 3	 task done.
         * 2	 task done.
         * 6	 task done.
         * 1	 task done.
         * 4	 task done.
         * 5	 task done.
         * project done.
         */
    }

}
