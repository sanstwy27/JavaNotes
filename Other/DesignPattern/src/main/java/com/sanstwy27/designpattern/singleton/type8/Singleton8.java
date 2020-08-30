package com.sanstwy27.designpattern.singleton.type8;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 * @comment Lazy loading (Thread Safe), recommended
 */

public class Singleton8 {
    public static void main(String[] args) {
        Singleton instance = Singleton.INSTANCE;
        Singleton instance2 = Singleton.INSTANCE;
        System.out.println(instance == instance2);

        System.out.println(instance.hashCode());
        System.out.println(instance2.hashCode());

        instance.sayOK();

        /**
         * true
         * 2046562095
         * 2046562095
         * ok~
         */
    }
}

enum Singleton {
    INSTANCE;
    public void sayOK() {
        System.out.println("ok~");
    }
}