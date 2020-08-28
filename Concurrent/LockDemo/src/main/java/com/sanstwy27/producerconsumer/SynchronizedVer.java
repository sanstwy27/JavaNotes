package com.sanstwy27.producerconsumer;

/**
 * @author Sanstwy27
 * @create 8/28/2020
 */

/**
 * As in the one argument version, interrupts and spurious wakeups are possible, and this method should always be used in a loop:
 *
 *      synchronized (obj) {
 *          while (<condition does not hold>)
 *              obj.wait();
 *          ... // Perform action appropriate to condition
 *      }
 */
public class SynchronizedVer {
    private volatile int number = 0;

    public synchronized void increment()
    {
        try
        {
            while(number > 0)
            {
                this.wait();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        ++number;
        System.out.println(Thread.currentThread().getName() + " --> " + number);
        this.notifyAll();
    }

    public synchronized void decrement()
    {
        try {
            while (number <= 0)
            {
                this.wait();
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        --number;
        System.out.println(Thread.currentThread().getName() + " --> " + number);
        this.notifyAll();
    }

    public static void main(String[] args)
    {
        SynchronizedVer producerConsumer = new SynchronizedVer();
        new Thread(()->{for (int i = 0 ; i < 10; ++i){producerConsumer.increment();}},"A").start();
        new Thread(()->{for (int i = 0 ; i < 10; ++i){producerConsumer.increment();}},"B").start();
        new Thread(()->{for (int i = 0 ; i < 10 ; ++i){producerConsumer.decrement();}},"C").start();
        new Thread(()->{for (int i = 0 ; i < 10 ; ++i){producerConsumer.decrement();}},"D").start();
    }
}
