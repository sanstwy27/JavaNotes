package com.sanstwy27.completablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureDemo {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFuture<Void> completableFuture1 = CompletableFuture.runAsync(() -> {
           System.out.println(Thread.currentThread().getName() + " without result, update mysql ok");
        });
        completableFuture1.get();

        CompletableFuture<Integer> completableFuture2 = CompletableFuture.supplyAsync(() -> {
            System.out.println(Thread.currentThread().getName() + " with result, insert mysql ok");
            int age = 10 / 0;
            return 1024;
        });
        System.out.println(completableFuture2.whenComplete((t, u) -> {
            System.out.println("**** t: " + t);
            System.out.println("**** u: " + u);
        }).exceptionally(f -> {
            System.out.println("**** exception: " + f.getMessage());
            return -1;
        }).get());

        /**
         * 1. No Exception
         *
         * ForkJoinPool.commonPool-worker-3 without result, update mysql ok
         * ForkJoinPool.commonPool-worker-3 with result, insert mysql ok
         * **** t: 1024
         * **** u: null
         * 1024
         *
         *
         * 2. Exception (int age = 10 / 0;)
         *
         * ForkJoinPool.commonPool-worker-3 without result, update mysql ok
         * ForkJoinPool.commonPool-worker-3 with result, insert mysql ok
         * **** t: null
         * **** u: java.util.concurrent.CompletionException: java.lang.ArithmeticException: / by zero
         * **** exception: java.lang.ArithmeticException: / by zero
         * -1
         *
         */
    }

}
