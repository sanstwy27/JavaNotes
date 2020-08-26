package com.sanstwy27.jvmquestions.oom;

/**
 * @author Sanstwy27
 * @create 8/26/2020
 */

public class StackOverflowErrorDemo {
    public static void main(String[] args) {
        StackOverflowError();

        /**
         * Exception in thread "main" java.lang.StackOverflowError
         * 	at com.sanstwy27.jvmquestions.oom.StackOverflowErrorDemo.StackOverflowError(StackOverflowErrorDemo.java:14)
         * 	at com.sanstwy27.jvmquestions.oom.StackOverflowErrorDemo.StackOverflowError(StackOverflowErrorDemo.java:14)
         * 	at com.sanstwy27.jvmquestions.oom.StackOverflowErrorDemo.StackOverflowError(StackOverflowErrorDemo.java:14)
         * 	...
         * 	...
         * 	at com.sanstwy27.jvmquestions.oom.StackOverflowErrorDemo.StackOverflowError(StackOverflowErrorDemo.java:14)
         * 	at com.sanstwy27.jvmquestions.oom.StackOverflowErrorDemo.StackOverflowError(StackOverflowErrorDemo.java:14)
         * 	at com.sanstwy27.jvmquestions.oom.StackOverflowErrorDemo.StackOverflowError(StackOverflowErrorDemo.java:14)
         */
    }

    public static void StackOverflowError() {
        StackOverflowError();
    }
}
