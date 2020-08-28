package com.sanstwy27.lockquiz;

import java.util.concurrent.TimeUnit;

/**
 * @author Sanstwy27
 * @create 8/28/2020
 */

class Phone7 {
    public static synchronized void sendEmail() throws Exception {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----sendEmail");
    }

    public synchronized void sendSMS() throws Exception {
        System.out.println("-----sendSMS");
    }

    public void hello() {
        System.out.println("----hello");
    }
}

public class Lock7 {
    public static void main(String[] args) throws InterruptedException {
        Phone7 phone7 = new Phone7();

        new Thread(() -> {
            try {
                phone7.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(200);

        new Thread(() -> {
            try {
                phone7.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();

        /**
         * -----sendSMS
         * -----sendEmail
         */
    }
}
