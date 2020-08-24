package com.sanstwy27;

public class ReentrantLockAndConditionDemo {
    public static void main(String[] args) {
        SharedData sharedData = new SharedData();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                sharedData.print5times();
            }
        }, "A").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                sharedData.print10times();
            }
        }, "B").start();

        new Thread(() -> {
            for (int i = 1; i <= 10; i++) {
                sharedData.print15times();
            }
        }, "C").start();

        /**
         * A	1
         * A	2
         * A	3
         * A	4
         * A	5
         * B	1
         * B	2
         * B	3
         * B	4
         * B	5
         * B	6
         * B	7
         * B	8
         * B	9
         * B	10
         * C	1
         * C	2
         * C	3
         * C	4
         * C	5
         * C	6
         * C	7
         * C	8
         * C	9
         * C	10
         * C	11
         * C	12
         * C	13
         * C	14
         * C	15
         * ...
         * (repeat 10 times)
         * ...
         */
    }
}