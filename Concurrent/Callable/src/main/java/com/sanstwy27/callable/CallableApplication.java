package com.sanstwy27.callable;

import org.springframework.boot.SpringApplication;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableApplication {

    public static void main(String[] args) {
        //demo1();
        //demo2();
        demo3();
    }

    /****
     * Basic demo
     */
    public static void demo1() {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());

        Thread t1 = new Thread(futureTask, "AA");
        t1.start();

        try {
            System.out.println("**** result：" + futureTask.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /**
         * AA	 **** come in Callable
         * **** result：1024
         */
    }

    /****
     * 1. Get the return value of call() from futureTask
     * 2. FutureTask.get() will be blocked, so strongly recommended for postponing it
     */
    public static void demo2() {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask, "AA").start();

        int result01 = 100;

        /*
        while(!futureTask.isDone()) {
            // waiting
        }
         */

        try {
            int result02 = futureTask.get();
            System.out.println("**** result：" + (result01 + result02));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /**
         * AA	 **** come in Callable
         * **** result：1124
         */
    }

    /****
     * Same task will be executed only once.
     */
    public static void demo3() {
        FutureTask<Integer> futureTask = new FutureTask<>(new MyThread());
        new Thread(futureTask, "AA").start();
        new Thread(futureTask, "BB").start();

        int result01 = 100;

        /*
        while(!futureTask.isDone()) {
            // waiting
        }
         */

        try {
            int result02 = futureTask.get();
            System.out.println("**** result：" + (result01 + result02));
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        /**
         * AA	 **** come in Callable
         * **** result：1124
         */
    }
}
