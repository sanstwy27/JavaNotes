package com.sanstwy27.designpattern.observer._jdk;

import java.util.Observable;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Example {
    public static void main(String[] args) {
        //Observable
        /**
         * 1. === Subject
         * @Deprecated(since="9")
         * public class Observable {
         *     private boolean changed = false;
         *     private Vector<Observer> obs;
         *     ...
         *     public synchronized void addObserver(Observer o) {
         *         ...
         *     }
         *     ...
         *     public synchronized void deleteObserver(Observer o) {
         *         ...
         *     }
         *     ...
         *     public void notifyObservers() {
         *         ...
         *     }
         *     ...
         * }
         *
         * 2. === Observer
         * @Deprecated(since="9")
         * public interface Observer {
         *     ...
         *     void update (Observable o, Object arg);
         * }
         *
         *
         */
    }
}
