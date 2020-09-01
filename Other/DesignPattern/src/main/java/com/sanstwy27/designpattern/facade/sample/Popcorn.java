package com.sanstwy27.designpattern.facade.sample;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Popcorn {
    private static Popcorn instance = new Popcorn();

    private Popcorn() {

    }

    public static Popcorn getInstance() {
        return instance;
    }

    public void on() {
        System.out.println(" popcorn on ");
    }

    public void off() {
        System.out.println(" popcorn off ");
    }

    public void pop() {
        System.out.println(" popcorn is poping  ");
    }
}
