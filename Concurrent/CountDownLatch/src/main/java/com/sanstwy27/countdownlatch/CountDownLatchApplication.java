package com.sanstwy27.countdownlatch;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchApplication {

    public static void main(String[] args) {
        int count = 6;
        CountDownLatch countDownLatch = new CountDownLatch(count);

        for (int i = 1; i <= count; i++) {
            new Thread(() -> {
                System.out.println(Thread.currentThread().getName() + "\t punches out.");
                countDownLatch.countDown();
            }, EmployeeEnum.getMsg(i).getRetEmpName()).start();
        }

        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Security lock door.");

        /**
         * Eve       punches out.
         * Charlie   punches out.
         * David     punches out.
         * Alice     punches out.
         * Bob       punches out.
         * Frank     punches out.
         * Security  lock door.
         */
    }

}
