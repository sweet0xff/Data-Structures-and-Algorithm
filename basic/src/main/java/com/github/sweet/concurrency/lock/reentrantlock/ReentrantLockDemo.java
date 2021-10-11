package com.github.sweet.concurrency.lock.reentrantlock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @description 演示可重入锁
 * @date 2021/10/10 21:52
 */
public class ReentrantLockDemo {
    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        accessResource();
    }
    public static void accessResource() {
        lock.lock();
        try {
            if (lock.getHoldCount() < 5) {
                System.out.println(lock.getHoldCount());
                accessResource();
            }
        } finally {
            lock.unlock();
            System.out.println(lock.getHoldCount());
        }

    }
}

