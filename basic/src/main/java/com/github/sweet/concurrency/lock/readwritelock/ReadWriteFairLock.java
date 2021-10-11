package com.github.sweet.concurrency.lock.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author
 * @description 读锁可以同时获取，但是写锁只能有一个线程获取
 * @date 2021/10/9 13:14
 */
public class ReadWriteFairLock {
    static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
    static ReentrantReadWriteLock.WriteLock writeLock = reentrantReadWriteLock.writeLock();
    static ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();

    public static void main(String[] args) {
        new Thread(() -> write(), "thread1").start();
        new Thread(() -> read(), "thread2").start();
        new Thread(() -> read(), "thread3").start();
        new Thread(() -> write(), "thread4").start();
        new Thread(() -> read(), "thread5").start();
        new Thread(() -> {
            Thread[] threads = new Thread[100];
            for (int i = 0; i < 100; i++) {
                threads[i] = new Thread(() -> read(), "子线程创建的Thread" + i);
            }
            for (int i = 0; i < 100; i++) {
                threads[i].start();
            }
        }).start();

    }
    static void read() {
        System.out.println(Thread.currentThread().getName() + "开始尝试获取读锁");
        readLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "拿到了读锁");
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了读锁");
        }
    }

    static void write() {
        System.out.println(Thread.currentThread().getName() + "开始尝试获取写锁");
        writeLock.lock();
        try {
            System.out.println(Thread.currentThread().getName() + "拿到了写锁");
            Thread.sleep(40);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
            System.out.println(Thread.currentThread().getName() + "释放了写锁");
        }
    }
}
