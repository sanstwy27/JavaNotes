package com.sanstwy27.jvmquestions.nativeif;

/**
 * @author Sanstwy27
 * @create 8/29/2020
 */

public class NativeInterfaceDemo {
    public static void main(String[] args) {
        Thread t = new Thread();
        t.start();

        /**
         * public synchronized void start() {
         *     ...
         *     start0();
         *     ...
         * }
         *
         * private native void start0(); -> C/C++ Process
         *
         */
    }
}
