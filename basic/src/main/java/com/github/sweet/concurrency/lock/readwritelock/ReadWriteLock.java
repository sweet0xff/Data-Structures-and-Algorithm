package com.github.sweet.concurrency.lock.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author
 * @description 读锁可以同时获取，但是写锁只能有一个线程获取
 * @date 2021/10/9 13:14
 */
public class ReadWriteLock {
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
    static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    public static void main(String[] args) {
        new Thread(() -> read()).start();
        new Thread(() -> read()).start();
        new Thread(() -> write()).start();
        new Thread(() -> read()).start();
        new Thread(() -> write()).start();

    }
    static void read() {
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "拿到了读锁");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了读锁");
        }
    }

    static void write() {
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "拿到了写锁");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了写锁");
        }
    }
}
