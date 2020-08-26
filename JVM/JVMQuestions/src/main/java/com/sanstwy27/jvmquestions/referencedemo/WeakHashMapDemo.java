package com.sanstwy27.jvmquestions.referencedemo;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

/**
 * @author Sanstwy27
 * @create 8/26/2020
 */

public class WeakHashMapDemo {
    public static void main(String[] args) {
        //myHashmap();
        myWeakHashmap();
    }

    public static void myHashmap() {
        Map<Integer, String> map = new HashMap<>();

        Integer i = new Integer(1);
        map.put(i, "123");
        System.out.println(map);
        /**
         * {1=123}
         */

        i = null;
        System.out.println(map);
        /**
         * {1=123}
         */

        System.gc();
        System.out.println(map);
        /**
         * {1=123}
         */
    }

    public static void myWeakHashmap() {
        WeakHashMap<Integer, String> map = new WeakHashMap<>();

        Integer i = new Integer(1);
        map.put(i, "123");
        System.out.println(map);
        /**
         * {1=123}
         */

        i = null;
        System.out.println(map);
        /**
         * {1=123}
         */

        System.gc();
        System.out.println(map);
        /**
         * {}
         */
    }
}
