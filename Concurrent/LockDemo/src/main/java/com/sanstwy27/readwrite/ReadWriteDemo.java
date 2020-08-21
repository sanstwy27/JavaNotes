package com.sanstwy27.readwrite;

/**
 * @author Sanstwy27
 * @create 8/21/2020
 */

public class ReadWriteDemo {
    public static void main(String[] args) {
        MyCache myCache = new MyCache();

        // Writing Thread
        for (int i = 1; i <= 5; i++) {
            // variable must be final in lambda
            final int temp = i;
            new Thread(() -> {
                myCache.put(temp + "", temp + "");
            }, String.valueOf(i)).start();
        }

        // Reading Thread
        for (int i = 1; i <= 5; i++) {
            final int temp = i;
            new Thread(() -> {
                myCache.get(temp + "");
            }, String.valueOf(i)).start();
        }
    }
}
