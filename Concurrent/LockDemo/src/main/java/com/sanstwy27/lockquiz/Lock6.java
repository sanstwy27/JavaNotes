package com.sanstwy27.lockquiz;

import java.util.concurrent.TimeUnit;

/**
 * @author Sanstwy27
 * @create 8/28/2020
 */

class Phone6 {
    public static synchronized void sendEmail() throws Exception {
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("-----sendEmail");
    }

    public static synchronized void sendSMS() throws Exception {
        System.out.println("-----sendSMS");
    }

    public void hello() {
        System.out.println("----hello");
    }
}

public class Lock6 {
    public static void main(String[] args) throws InterruptedException {
        Phone6 phone6a = new Phone6();
        Phone6 phone6b = new Phone6();

        new Thread(() -> {
            try {
                phone6a.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(200);

        new Thread(() -> {
            try {
                phone6b.sendSMS();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();

        /**
         * -----sendEmail
         * -----sendSMS
         */
    }
}
