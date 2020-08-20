package com.sanstwy27.casdemo;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author Sanstwy27
 * @create 8/20/2020
 */

public class SolveABA {
    public static void main(String[] args) {
        AtomicStampedReference<Integer> atomicStampedReference = new AtomicStampedReference<>(100, 1);

        // ABA Thread
        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("Tread1 stamp v1: " + stamp);

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            atomicStampedReference.compareAndSet(100,
                    101,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);
            System.out.println("Tread1 stamp v2：" + atomicStampedReference.getStamp());

            atomicStampedReference.compareAndSet(101,
                    100,
                    atomicStampedReference.getStamp(),
                    atomicStampedReference.getStamp() + 1);
            System.out.println("Tread1 stamp v3: " + atomicStampedReference.getStamp());
        }).start();

        new Thread(() -> {
            int stamp = atomicStampedReference.getStamp();
            System.out.println("Tread2 stamp v1: " + stamp);

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            boolean result = atomicStampedReference.compareAndSet(100,
                    2020,
                    stamp,
                    stamp + 1);
            System.out.println("Tread2 compareAndSet result: " + result);
            System.out.println("Tread2 current stamp: " + atomicStampedReference.getStamp());
        }).start();
    }
}
