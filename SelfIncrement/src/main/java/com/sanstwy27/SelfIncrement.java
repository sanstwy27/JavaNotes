package com.sanstwy27;

/**
 * @author Sanstwy27
 * @create 8/17/2020
 */

public class SelfIncrement {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println("i = " + i); // 4
        System.out.println("j = " + j); // 1
        System.out.println("k = " + k); // 11
    }
}
