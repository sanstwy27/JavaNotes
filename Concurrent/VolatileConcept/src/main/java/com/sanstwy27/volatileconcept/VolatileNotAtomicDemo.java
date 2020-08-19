package com.sanstwy27.volatileconcept;

public class VolatileNotAtomicDemo {

    public static void main(String[] args) {
        MyData data = new MyData();

        for (int i = 1; i <= 20; i++) {
            new Thread(() -> {
                // add 1000 times at each thread
                for (int j = 0; j < 1000; j++) {
                    data.addOne();
                    data.addAtomic();
                }
            }).start();
        }

        // Thread.activeCount = (main and gc thread) + (child threads)
        while (Thread.activeCount() > 2) {
            // main thread is waiting
            Thread.yield();
        }

        System.out.println(Thread.currentThread().getName() + "\t int type, finally number value: " + data.number);
        System.out.println(Thread.currentThread().getName() + "\t Atomic type, finally number value: " + data.atomicInteger);
    }
}

