package com.sanstwy27.designpattern.singleton.type7;

/**
 * @author Sanstwy27
 * @create 8/30/2020
 * @comment Lazy loading (Thread Safe), recommended
 */

public class Singleton7 {
    public static void main(String[] args) {
        Singleton instance = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();
        System.out.println(instance == instance2);
        System.out.println("instance.hashCode=" + instance.hashCode());
        System.out.println("instance2.hashCode=" + instance2.hashCode());

        /**
         * true
         * instance.hashCode=1342443276
         * instance2.hashCode=1342443276
         */
    }
}

class Singleton {
    private Singleton() {}

    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }
}