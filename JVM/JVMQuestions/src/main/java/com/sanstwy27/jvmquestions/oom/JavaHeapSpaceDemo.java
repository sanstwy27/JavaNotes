package com.sanstwy27.jvmquestions.oom;

import java.util.Random;

/**
 * @author Sanstwy27
 * @create 8/26/2020
 */

public class JavaHeapSpaceDemo {
    static final int SIZE = 2 * 1024 * 1024;
    public static void main(String[] args) {
        // -Xmx10m
        int[] i = new int[SIZE];
        /**
         * Exception in thread "main" java.lang.OutOfMemoryError: Overflow: String length out of range
         * 	at java.base/java.lang.StringConcatHelper.checkOverflow(StringConcatHelper.java:53)
         * 	at java.base/java.lang.StringConcatHelper.mix(StringConcatHelper.java:134)
         * 	at com.sanstwy27.jvmquestions.oom.OutOfMemoryErrorHeapDemo.main(OutOfMemoryErrorHeapDemo.java:14)
         */
    }
}
