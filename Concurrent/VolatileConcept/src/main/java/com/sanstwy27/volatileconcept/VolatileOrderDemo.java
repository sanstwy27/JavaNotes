package com.sanstwy27.volatileconcept;

/**
 * @author Sanstwy27
 * @create 8/19/2020
 */

public class VolatileOrderDemo {
    public static void main(String[] args) {
        // Ordering Problem without Volatile in Multi-thread
        int a = 0;
        boolean flag = false;

        // statement 1 <---- thread 1
        a = 1;
        // statement 2
        flag = true;
        // statement 3 <---- thread 3
        if (flag) {
            a += 5;
            System.out.println(a);
        }
    }
}
