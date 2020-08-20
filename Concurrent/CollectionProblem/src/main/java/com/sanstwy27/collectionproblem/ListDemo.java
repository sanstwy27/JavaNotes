package com.sanstwy27.collectionproblem;

import org.junit.Test;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author Sanstwy27
 * @create 8/20/2020
 */

public class ListDemo {

    public static void main(String[] args) {
        // Vector
        // Vector extends AbstractList，and AbstractList implements List Interface
        demo1();
        // Collections.synchronizedList() with list instance
        demo2();
        // CopyOnWriteArrayList
        demo3();
    }

    public static void demo1() {
        List<String> list = new Vector<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
    }

    public static void demo2() {
        List<String> list = Collections.synchronizedList(new ArrayList<>());

        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                list.add(String.valueOf(UUID.randomUUID().toString().substring(0, 8)));
                System.out.println(list);
            }).start();
        }
    }

    public static void demo3() {
        List<String> list = new CopyOnWriteArrayList<>();

        for (int i = 1; i <= 30; i++) {
            new Thread(()->{
                list.add(String.valueOf(UUID.randomUUID().toString().substring(0, 8)));
                System.out.println(list);
            }).start();
        }
    }
}
