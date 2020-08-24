package com.sanstwy27.blockingqueue.prodconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sanstwy27
 * @create 8/24/2020
 */

public class ShareDataTradition {
    private int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    // Producer
    public void increase() {
        lock.lock();
        try {
            // 1. check
            // avoid spurious wakeup
            while (number != 0) {
                condition.await();
            }
            // 2. produce
            number++;
            System.out.println(Thread.currentThread().getName() + " produce:" + number);
            // 3. done
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }

    // Consumer
    public void decrease() {
        lock.lock();
        try {
            // 1. check
            while (number == 0) {
                condition.await();
            }
            // 2. consume
            number--;
            System.out.println(Thread.currentThread().getName() + " consume:" + number);
            // 3. done
            condition.signalAll();
        } catch (Exception e) {

        } finally {
            lock.unlock();
        }
    }
}
