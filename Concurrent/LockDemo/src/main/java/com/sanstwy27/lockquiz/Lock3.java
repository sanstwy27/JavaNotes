package com.sanstwy27.lockquiz;

import java.util.concurrent.TimeUnit;

/**
 * @author Sanstwy27
 * @create 8/28/2020
 */

class Phone3 {
    public synchronized void sendEmail() throws Exception {
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

public class Lock3 {
    public static void main(String[] args) throws InterruptedException {
        Phone3 phone3 = new Phone3();

        new Thread(() -> {
            try {
                phone3.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(200);

        new Thread(() -> {
            try {
                phone3.hello();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "B").start();

        /**
         * ----hello
         * -----sendEmail
         */
    }
}
