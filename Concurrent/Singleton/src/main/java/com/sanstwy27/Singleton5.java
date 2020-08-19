package com.sanstwy27;

/**
 * @author Sanstwy27
 * @create 8/17/2020
 * @note Lazy loading (thread safe)
 */

public class Singleton5 {
    // Why volatile?
    // consider [INSTANCE = new Singleton5();]
    //
    // Pseudocode
    // 1. memory = allocate();
    //    instance(memory);  ----> instance initialized
    //    instance = memory; ----> instance != null
    //
    // 2. memory = allocate();
    //    instance = memory; ----> instance != null
    //    instance(memory);  ----> instance initialized
    private volatile static Singleton5 INSTANCE;
    private Singleton5() {

    }

    public static Singleton5 getInstance() throws InterruptedException {
        if (INSTANCE == null) {
            synchronized (Singleton5.class) {
                if (INSTANCE == null) {
                    Thread.sleep(100);
                    INSTANCE = new Singleton5();
                }
            }
        }
        return INSTANCE;
    }
}
