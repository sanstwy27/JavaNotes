package com.sanstwy27;

/**
 * @author Sanstwy27
 * @create 8/17/2020
 */

public class Singleton6 {
    private Singleton6() {

    }
    private static class Inner {
        private static final Singleton6 INSTANCE = new Singleton6();
    }

    public static Singleton6 getInstance() {
        return Inner.INSTANCE;
    }
}
