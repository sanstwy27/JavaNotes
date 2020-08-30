package com.sanstwy27.designpattern.adapter.interfaceadapter;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Client {
    public static void main(String[] args) {
        AbsAdapter absAdapter = new AbsAdapter() {
            // Optional Override
            @Override
            public void m1() {
                System.out.println("calling m1()");
            }
        };

        absAdapter.m1();

        /**
         * calling m1()
         */
    }
}
