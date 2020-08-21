package com.sanstwy27.reentrantlockdemo;

public class ReentrantlockDemoApplication {

    public static void main(String[] args) {
        /**
         * synchronized
         */
        //synchronizedDemo();
        /**
         * ReentrantLock
         */
        //ReentrantLockDemo1();
        ReentrantLockDemo2();
    }

    public static void synchronizedDemo() {
        Phone phone = new Phone();
        new Thread(phone::sendSmg).start();
        new Thread(phone::sendSmg).start();
    }

    public static void ReentrantLockDemo1() {
        Phone phone = new Phone();
        Thread thread1 = new Thread(phone,"t1");
        Thread thread2 = new Thread(phone,"t2");
        thread1.start();
        thread2.start();
    }

    public static void ReentrantLockDemo2() {
        Phone phone = new Phone();
        Thread thread1 = new Thread(phone::method3,"t3");
        Thread thread2 = new Thread(phone::method3,"t4");
        thread1.start();
        thread2.start();
    }
}
