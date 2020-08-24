package com.sanstwy27.blockingqueue.prodconsumer;

/**
 * @author Sanstwy27
 * @create 8/24/2020
 */

public class ProdConsumerTradition {
    public static void main(String[] args) {
        int threadCount = 5;
        ShareDataTradition shareDataTradition = new ShareDataTradition();

        // Producer Threads
        new Thread(() -> {
            for (int i = 1; i <= threadCount; i++) {
                shareDataTradition.increase();
            }
        }, "AA").start();

        // Consumer Threads
        new Thread(() -> {
            for (int i = 1; i <= threadCount; i++) {
                shareDataTradition.decrease();
            }
        }, "BB").start();

        /**
         * AA produce:1
         * BB consume:0
         * AA produce:1
         * BB consume:0
         * AA produce:1
         * BB consume:0
         * AA produce:1
         * BB consume:0
         * AA produce:1
         * BB consume:0
         */
    }
}
