package com.sanstwy27.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sanstwy27
 * @create 8/28/2020
 * @what print5Times() -> print10Times() -> print15Times(), repeat 3 times
 */

public class ThreadOrderAccessDemo {
    private volatile int num = 0;

    private volatile int flag = 1;

    private Lock lock = new ReentrantLock();

    private Condition c1 = lock.newCondition();
    private Condition c2 = lock.newCondition();
    private Condition c3 = lock.newCondition();

    public void print5Times()
    {
        lock.lock();
        try
        {
            while (flag != 1)
            {
                c1.await();
            }
            ++num;
            for (int i = 0 ;i < 5; ++i)
            {
                System.out.println(Thread.currentThread().getName() + " --> " + num);
            }

            flag = 2;
            c2.signal();
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

    public void print10Times()
    {
        lock.lock();
        try
        {
            while (flag != 2)
            {
                c2.await();
            }
            ++num;
            for (int i = 0 ;i < 10; ++i)
            {
                System.out.println(Thread.currentThread().getName() + " --> " + num);
            }

            flag = 3;
            c3.signal();
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

    public void print15Times()
    {
        lock.lock();
        try
        {
            while (flag != 3)
            {
                c3.await();
            }
            ++num;
            for (int i = 0 ;i < 15; ++i)
            {
                System.out.println(Thread.currentThread().getName() + " --> " + num);
            }

            flag = 1;
            c1.signal();
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
        ThreadOrderAccessDemo threadOrderAccessDemo = new ThreadOrderAccessDemo();
        new Thread(()->{for (int i = 0; i < 3 ; ++i){threadOrderAccessDemo.print5Times();}},"A").start();
        new Thread(()->{for (int i = 0; i < 3 ; ++i){threadOrderAccessDemo.print10Times();}},"B").start();
        new Thread(()->{for (int i = 0; i < 3 ; ++i){threadOrderAccessDemo.print15Times();}},"C").start();

        /**
         * A --> 1
         * A --> 1
         * A --> 1
         * A --> 1
         * A --> 1
         * B --> 2
         * B --> 2
         * B --> 2
         * B --> 2
         * B --> 2
         * B --> 2
         * B --> 2
         * B --> 2
         * B --> 2
         * B --> 2
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * C --> 3
         * A --> 4
         * A --> 4
         * A --> 4
         * A --> 4
         * A --> 4
         * B --> 5
         * B --> 5
         * B --> 5
         * B --> 5
         * B --> 5
         * B --> 5
         * B --> 5
         * B --> 5
         * B --> 5
         * B --> 5
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * C --> 6
         * A --> 7
         * A --> 7
         * A --> 7
         * A --> 7
         * A --> 7
         * B --> 8
         * B --> 8
         * B --> 8
         * B --> 8
         * B --> 8
         * B --> 8
         * B --> 8
         * B --> 8
         * B --> 8
         * B --> 8
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         * C --> 9
         */
    }
}
