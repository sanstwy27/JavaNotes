package com.sanstwy27.jvmquestions;

/**
 * @author Sanstwy27
 * @create 8/26/2020
 */

public class StrongReferenceDemo {
    public static void main(String[] args) {
        Object obj1 = new Object(); // Strong Reference
        Object obj2 = new Object();
        obj1 = null;
        System.gc();
        System.out.println(obj2);

        /**
         * java.lang.Object@6f539caf
         */
    }
}
