package com.sanstwy27.jvmquestions.referencedemo;

import java.lang.ref.WeakReference;

/**
 * @author Sanstwy27
 * @create 8/26/2020
 */

public class WeakReferenceDemo {
    public static void main(String[] args) {
        Object o = new Object();
        WeakReference<Object> weakReference = new WeakReference<>(o);

        System.out.println(o);
        System.out.println(weakReference.get());
        /**
         * java.lang.Object@6f539caf
         * java.lang.Object@6f539caf
         */

        o = null;
        System.gc();

        System.out.println(o);
        System.out.println(weakReference.get());
        /**
         * null
         * null
         */
    }
}
