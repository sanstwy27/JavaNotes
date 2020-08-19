package com.sanstwy27.volatileconcept;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Sanstwy27
 * @create 8/19/2020
 */
class MyData {
    //int number = 0;
    volatile int number = 0;
    AtomicInteger atomicInteger = new AtomicInteger();

    public void turnTo60() {
        this.number = 60;
    }

    public void addOne() {
        number++;
    }

    public void addAtomic() {
        atomicInteger.getAndIncrement();
    }
}
