package com.sanstwy27.designpattern.composite._jdk;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Sanstwy27
 * @create 8/31/2020
 */

public class Example {
    public static void main(String[] args) {
        Map<Integer,String> hashMap=new HashMap<Integer,String>();
        /**
         * 1.
         *   public interface Map<K, V>
         *
         * 2.
         *   public abstract class AbstractMap<K,V> implements Map<K,V>
         *
         * 3.
         *   public class HashMap<K,V> extends AbstractMap<K,V>
         *     implements Map<K,V>, Cloneable, Serializable {       -> Composite
         *     ...
         *     static class Node<K,V> implements Map.Entry<K,V> {   -> Leaf
         *         ...
         *     }
         *     ...
         *
         */
        // Leaf(Node)
        hashMap.put(0, "Book1");

        Map<Integer,String> map=new HashMap<Integer,String>();
        map.put(1, "Book2");
        map.put(2, "Book3"); //..
        hashMap.putAll(map);
        System.out.println(hashMap);
    }
}
