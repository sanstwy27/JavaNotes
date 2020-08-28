package com.sanstwy27.producerconsumer;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sanstwy27
 * @create 8/28/2020
 */

public class LockVer {
    private volatile int number = 0;
    private Lock lock = new ReentrantLock();
    private Condition condition = lock.newCondition();

    public void increment()
    {
        lock.lock();
        try
        {
            while (number > 0)
            {
                condition.await();
            }
            ++number;
            System.out.println(Thread.currentThread().getName() + " --> " + number);
            condition.signalAll();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }
    }

    public void decrement()
    {
        lock.lock();
        try
        {
            while (number <= 0)
            {
                condition.await();
            }
            --number;
            System.out.println(Thread.currentThread().getName() + " --> " + number);
            condition.signalAll();
        }
        catch(InterruptedException e)
        {
            e.printStackTrace();
        }
        finally
        {
            lock.unlock();
        }
    }

    public static void main(String[] args)
    {
        LockVer producerConsumer = new LockVer();
        new Thread(()->{for (int i = 0 ; i < 10; ++i){producerConsumer.increment();}},"A").start();
        new Thread(()->{for (int i = 0 ; i < 10; ++i){producerConsumer.increment();}},"B").start();
        new Thread(()->{for (int i = 0 ; i < 10 ; ++i){producerConsumer.decrement();}},"C").start();
        new Thread(()->{for (int i = 0 ; i < 10 ; ++i){producerConsumer.decrement();}},"D").start();
    }
}
