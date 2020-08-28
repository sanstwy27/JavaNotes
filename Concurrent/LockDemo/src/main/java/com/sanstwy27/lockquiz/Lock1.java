package com.sanstwy27.lockquiz;

/**
 * @author Sanstwy27
 * @create 8/28/2020
 */

class Phone1 {
    public synchronized void sendEmail() throws Exception {
        System.out.println("-----sendEmail");
    }

    public synchronized void sendSMS() throws Exception {
        System.out.println("-----sendSMS");
    }
}

public class Lock1 {
    public static void main(String[] args) throws InterruptedException {
        Phone1 phone = new Phone1();

        new Thread(() -> {
            try {
                phone.sendEmail();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, "A").start();

        Thread.sleep(200);

        new Thread(() -> {
            try {
                phone.sendSMS();
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
