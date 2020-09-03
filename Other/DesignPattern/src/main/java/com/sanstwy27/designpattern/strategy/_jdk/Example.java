package com.sanstwy27.designpattern.strategy._jdk;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author Sanstwy27
 * @create 9/3/2020
 */

public class Example {
    public static void main(String[] args) {
        Integer[] data = { 9, 1, 2, 8, 4, 3 };

        // 1. implement Comparator interface (strategy interface) by nested class new Comparator<Integer>(){..}
        // 2. public int compare(Integer o1, Integer o2){} concrete method
        Comparator<Integer> comparator = new Comparator<Integer>() {
            public int compare(Integer o1, Integer o2) {
                if (o1 > o2) {
                    return -1;
                } else {
                    return 1;
                }
            };
        };

		/**
		 * public static <T> void sort(T[] a, Comparator<? super T> c) {
		        if (c == null) {
                    // default strategy
		            sort(a);
		        } else {
                    // strategy c
		            if (LegacyMergeSort.userRequested)
		                legacyMergeSort(a, c);
		            else
		                TimSort.sort(a, 0, a.length, c, null, 0, 0);
		        }
		    }
		 */
        // method 1
        Arrays.sort(data, comparator);
        System.out.println("data1 = " + Arrays.toString(data));


        // method 2 - lambda expr
        Integer[] data2 = { 19, 11, 12, 18, 14, 13 };
        Arrays.sort(data2, (var1, var2) -> {
            if(var1.compareTo(var2) > 0) {
                return -1;
            } else {
                return 1;
            }
        });
        System.out.println("data2 = " + Arrays.toString(data2));


        /**
         * data1 = [9, 8, 4, 3, 2, 1]
         * data2 = [19, 18, 14, 13, 12, 11]
         */
    }
}
