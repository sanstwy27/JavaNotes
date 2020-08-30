package com.sanstwy27.designpattern.singleton.type1;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 * @comment Non-lazy loading (Thread Safe)
 */

public class Singleton1 {
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
    private Singleton() {

    }

    private final static Singleton instance = new Singleton();

    public static Singleton getInstance() {
        return instance;
    }

}