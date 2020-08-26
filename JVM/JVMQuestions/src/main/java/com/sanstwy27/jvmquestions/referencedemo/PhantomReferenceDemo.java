package com.sanstwy27.jvmquestions.referencedemo;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

/**
 * @author Sanstwy27
 * @create 8/26/2020
 */

public class PhantomReferenceDemo {
    public static void main(String[] args) {
        Object o = new Object();
        ReferenceQueue<Object> referenceQueue = new ReferenceQueue<>();
        PhantomReference<Object> phantomReference = new PhantomReference<>(o, referenceQueue);

        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
        /**
         * java.lang.Object@6f539caf
         * null
         * null
         */

        o =null;
        System.gc();

        System.out.println(o);
        System.out.println(phantomReference.get());
        System.out.println(referenceQueue.poll());
        /**
         * null
         * null
         * java.lang.ref.PhantomReference@79fc0f2f
         */
    }
}
