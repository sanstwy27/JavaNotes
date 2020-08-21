package com.sanstwy27.readwrite;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author Sanstwy27
 * @create 8/21/2020
 */

public class MyCache {
    private volatile Map<String, String> map = new HashMap<>();
    private ReentrantReadWriteLock rwlock = new ReentrantReadWriteLock();

    public void get(String key) {
        rwlock.writeLock().lock();
        try {
            System.out.println(String.format("%s is reading，key=%s",
                    Thread.currentThread().getName(),
                    key));
            Thread.sleep(300);
            Object result = map.get(key);
            System.out.println(String.format("%s has read completely，key=%s",
                    Thread.currentThread().getName(),
                    result));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwlock.writeLock().unlock();
        }
    }

    public void put(String key, String value) {
        rwlock.readLock().lock();
        try {
            System.out.println(String.format("%s is writing，key=%s",
                    Thread.currentThread().getName(),
                    key));
            Thread.sleep(300);
            map.put(key,value);
            System.out.println(String.format("%s has written completely，key=%s",
                    Thread.currentThread().getName(),
                    key));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            rwlock.readLock().unlock();
        }
    }
}
