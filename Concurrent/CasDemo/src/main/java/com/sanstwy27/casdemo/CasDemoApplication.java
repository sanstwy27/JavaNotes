package com.sanstwy27.casdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class CasDemoApplication {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(5);
        System.out.println(atomicInteger.compareAndSet(5,2020) + "\t current value: " + atomicInteger.get());
        System.out.println(atomicInteger.compareAndSet(5,2020) + "\t current value: " + atomicInteger.get());
        System.out.println(atomicInteger.getAndIncrement() + "\t current value: " + atomicInteger.get());
        /**
         * true	   current value: 2020
         * false   current value: 2020
         * 2020	   current value: 2021
         */

        User Alice = new User("Alice", 20);
        User Bob = new User("Bob", 24);

        AtomicReference<User> atomicReference = new AtomicReference<>();
        atomicReference.set(Alice);

        //var1：expected value
        //var2：new value
        System.out.println(atomicReference.compareAndSet(Alice, Bob));
        System.out.println(atomicReference.get().toString());

        System.out.println(atomicReference.compareAndSet(Alice, Bob));
        System.out.println(atomicReference.get().toString());
        /**
         * true
         * User{userName='Bob', age=24}
         * false
         * User{userName='Bob', age=24}
         */
    }
}
