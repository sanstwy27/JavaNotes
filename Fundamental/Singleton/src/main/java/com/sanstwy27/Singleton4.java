package com.sanstwy27;

/**
 * @author Sanstwy27
 * @create 8/17/2020
 * @note Lazy loading (not thread safe)
 */

public class Singleton4 {
    private static Singleton4 INSTANCE;
    private Singleton4() {

    }
    public static Singleton4 getInstance() throws InterruptedException {
        if(INSTANCE == null) {
            Thread.sleep(100);
            INSTANCE = new Singleton4();
        }
        return INSTANCE;
    }
}
