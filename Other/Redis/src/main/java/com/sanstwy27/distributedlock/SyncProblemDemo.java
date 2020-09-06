package com.sanstwy27.distributedlock;

import org.redisson.Redisson;
import org.redisson.config.Config;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author Sanstwy27
 * @create 9/6/2020
 */

@SpringBootApplication
public class SyncProblemDemo {
    public static void main(String[] args) {
        SpringApplication.run(SyncProblemDemo.class, args);
    }

    @Bean
    public Redisson redisson() {
        Config config = new Config();
        config.useSingleServer().setAddress("redis://127.0.0.1:16379").setDatabase(0);
        return (Redisson) Redisson.create(config);
    }
}
