package com.sanstwy27.casdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.concurrent.atomic.AtomicInteger;

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
    }
}
