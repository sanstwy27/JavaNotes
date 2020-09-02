package com.sanstwy27.designpattern.iterator._jdk;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author Sanstwy27
 * @create 9/2/2020
 */

public class Example {
    public static void main(String[] args) {
        List<String> a = new ArrayList<>();
        /**
         * 1.
         * public class ArrayList<E> extends AbstractList<E>
         *         implements List<E>, RandomAccess, Cloneable, java.io.Serializable
         * {
         *     ...
         * }
         *
         * 2.
         * public interface List<E> extends Collection<E> {
         *     ...
         *     Iterator<E> iterator();
         *     ...
         * }
         *
         * 3.
         * public class ArrayList<E> extends AbstractList<E>
         *         implements List<E>, RandomAccess, Cloneable, java.io.Serializable
         * {
         *     ...
         *     public Iterator<E> iterator() {
         *         return new Itr();
         *     }
         *     ...
         *     private class Itr implements Iterator<E> {
         *         ...
         *         // prevent creating a synthetic constructor
         *         Itr() {}
         *         ...
         *     }
         *     ...
         * }
         *
         *
         */
        a.add("Alice");

        Iterator itr = a.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
    }
}
