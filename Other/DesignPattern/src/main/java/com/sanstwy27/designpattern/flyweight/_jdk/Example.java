package com.sanstwy27.designpattern.flyweight._jdk;

/**
 * @author Sanstwy27
 * @create 9/1/2020
 */

public class Example {
    public static void main(String[] args) {
        Integer x = Integer.valueOf(127);
        Integer y = new Integer(127);
        Integer z = Integer.valueOf(127);
        Integer w = new Integer(127);
        /**
         * 1. [-128 - 127 using flyweight] faster than "new Integer"
         *     public final class Integer extends Number
         *         implements Comparable<Integer>, Constable, ConstantDesc {
         *         ...
         *         private static class IntegerCache {
         *             static final int low = -128;
         *             static final int high;
         *             ...
         *         }
         *         ...
         *         public static Integer valueOf(int i) {
         *             if (i >= IntegerCache.low && i <= IntegerCache.high)
         *                 return IntegerCache.cache[i + (-IntegerCache.low)];
         *             return new Integer(i);
         *         }
         *         ...
         *     }
         *
         *
         */

        System.out.println(x.equals(y));
        System.out.println(x == y );
        System.out.println(x == z );
        System.out.println(w == x );
        System.out.println(w == y );

        Integer x1 = Integer.valueOf(200);
        Integer x2 = Integer.valueOf(200);
        System.out.println("x1==x2 " + (x1 == x2));

        /**
         * true
         * false
         * true
         * false
         * false
         * x1==x2 false
         */
    }
}
