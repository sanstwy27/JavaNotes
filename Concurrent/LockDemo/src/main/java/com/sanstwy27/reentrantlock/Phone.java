package com.sanstwy27.reentrantlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sanstwy27
 * @create 8/21/2020
 */

public class Phone implements Runnable {
    /**
     * Reentrant 1
     * synchronized
     */
    public synchronized void sendSmg() {
        System.out.println(Thread.currentThread().getId() + "\t invoked sendSmg()");
        sendEmail();
    }

    public synchronized void sendEmail() {
        System.out.println(Thread.currentThread().getId() + "\t invoked sendEmail()");
    }

    /**
     * Reentrant 2
     * ReentrantLock()
     */
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        method1();
    }

    private void method1() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t method1()");
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    private void method2() {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t method2()");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void method3() {
        lock.lock();
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "\t method3()");
            method2();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
            //lock.unlock();
        }
    }
}
