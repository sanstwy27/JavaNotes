package com.sanstwy27.designpattern.singleton.serializable;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * @author Sanstwy27
 * @create 9/6/2020
 */

class Singleton implements Serializable {
    private Singleton() {}

    private static class SingletonInstance {
        private static final Singleton INSTANCE = new Singleton();
    }

    public static Singleton getInstance() {
        return SingletonInstance.INSTANCE;
    }

    Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}