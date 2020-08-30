package com.sanstwy27.designpattern.singleton.type6;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 * @comment Lazy loading (Thread Safe), recommended
 */

public class Singleton6 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

        /**
         * true
         * instance.hashCode=2046562095
         * instance2.hashCode=2046562095
         */
    }
}

class Singleton {
    private static volatile Singleton instance;

    private Singleton() {}

    public static synchronized Singleton getInstance() {
        if(instance == null) {
            synchronized (Singleton.class) {
                if(instance == null) {
                    instance = new Singleton();
                }
            }

        }
        return instance;
    }
}