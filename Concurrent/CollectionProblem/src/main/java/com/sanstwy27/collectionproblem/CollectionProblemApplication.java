package com.sanstwy27.collectionproblem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.*;

public class CollectionProblemApplication {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            new Thread(()->{
                list.add(UUID.randomUUID().toString().substring(0, 8));
                System.out.println(list);
            }).start();
        }
        // java.util.ConcurrentModificationException

        Map<String, String> map = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            new Thread(() -> {
                map.put(Thread.currentThread().getName(), UUID.randomUUID().toString().substring(0, 8));
                System.out.println(map);
            }).start();
        }
        // java.util.ConcurrentModificationException
    }
}
