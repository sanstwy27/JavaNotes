package com.sanstwy27.distributedlock.controller;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

/**
 * @author Sanstwy27
 * @create 9/6/2020
 * @comment
 * @reference https://www.evichen.com/2020/01/16/redis-lock/
 */

/**
 * [Hint]
 *
 * There are still some issues:
 *  ___________    ________________    _________________
 * | Servlet1 |<->| Redis(Master) |<->| Redis(Slave)   |
 * -----------    ----------------    -----------------
 *  ___________
 * | Servlet2 |----------------- ^^^^ ???
 * -----------
 *
 *  if(Master1 crash)
 *      locker will become invalid and
 *      will unlock all concurrency requests
 *
 * Solution:
 *     1. Redisson Redlock: lock cluster ( success to lock >= n / 2 )
 *       - AP in CAP theorem
 *     2. Zookeeper
 *       - CP in CAP theorem
 *
 */

@RestController
public class IndexController {
    @Autowired
    private Redisson redisson;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @RequestMapping("/deduct_stock_impl")
    public String deductStockImpl() {
        String lockKey = "lockKey";
        String clientId = UUID.randomUUID().toString();

        Boolean result = stringRedisTemplate.opsForValue().setIfAbsent(lockKey, clientId, 10, TimeUnit.SECONDS);
        if (!result) {
            return "error";
        }

        /**
         * Preventing Lock Expiration: we can use new thread to extend locker time
         */
        // TODO

        try {
            //jedis.get(key)
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                //jedis.set(key,value)
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("Success to deduct: " + realStock);
            } else {
                System.out.println("Failure to deduct.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (clientId.equals(stringRedisTemplate.opsForValue().get(lockKey))) {
                stringRedisTemplate.delete(lockKey);
            }
        }

        return "end";
    }

    @RequestMapping("/deduct_stock_redisson")
    public String deductStockRedisson() {
        String lockKey = "lockKey";
        RLock redissonLock = redisson.getLock(lockKey);
        try {
            // extend locker time automatically, default is 30s
            redissonLock.lock();
            //jedis.get(key)
            int stock = Integer.parseInt(stringRedisTemplate.opsForValue().get("stock"));
            if (stock > 0) {
                int realStock = stock - 1;
                //jedis.set(key,value)
                stringRedisTemplate.opsForValue().set("stock", realStock + "");
                System.out.println("Success to deduct: " + realStock);
            } else {
                System.out.println("Failure to deduct.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            redissonLock.unlock();
        }

        return "end";
    }
}
