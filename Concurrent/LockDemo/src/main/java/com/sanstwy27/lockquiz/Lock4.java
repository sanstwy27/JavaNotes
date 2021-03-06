package com.sanstwy27.lockquiz;

import java.util.concurrent.TimeUnit;

/**
 * @author Sanstwy27
 * @create 8/28/2020
 */

class Phone4 {
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

public class Lock4 {
    public static void main(String[] args) throws InterruptedException {
        Phone4 phone4a = new Phone4();
        Phone4 phone4b = new Phone4();

        new Thread(() -> {
            try {
                phone4a.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(200);

        new Thread(() -> {
            try {
                phone4b.sendSMS();
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
