package com.github.sweet.concurrency.cache;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author sweet
 * @description
 * @date 2021/11/3 11:14
 */
public class CacheDemo1<K, V> {
    final Map<K, V> map = new HashMap<>();
    public final ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock(false);
    public final Lock readLock = reentrantReadWriteLock.readLock();
    public final Lock writeLock = reentrantReadWriteLock.writeLock();

    V get(K key) {
        V v = null;
        readLock.lock();
        try {
            v = map.get(key);
        } finally {
            readLock.unlock();
        }

        if (v != null) {
            return v;
        } else {
            writeLock.lock();
            try {
                v = map.get(key);
            } finally {
                writeLock.unlock();
            }
        }
        return v;
    }
}
