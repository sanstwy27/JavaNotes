package com.sanstwy27;

/**
 * @author Sanstwy27
 * @create 8/17/2020
 * @note Non-lazy loading
 */

public class Singleton1 {
    public final static Singleton1 INSTANCE = new Singleton1();
    private  Singleton1() {

    }
}
