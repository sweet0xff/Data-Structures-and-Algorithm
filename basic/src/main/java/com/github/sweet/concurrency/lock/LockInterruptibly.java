package com.github.sweet.concurrency.lock;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @description t0 interrupt则会出现睡眠期间被打断，t1则是在等待获得锁的过程中被打断
 * @date 2021/10/11 08:55
 */
public class LockInterruptibly implements Runnable {
    static ReentrantLock reentrantLock = new ReentrantLock();

    public static void main(String[] args) {
        LockInterruptibly interruptibly = new LockInterruptibly();
        Thread t0 = new Thread(interruptibly);
        Thread t1 = new Thread(interruptibly);
        t0.start();
        t1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t0.interrupt();
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "尝试获取锁");
        try {
            reentrantLock.lockInterruptibly();
            try {
                System.out.println(Thread.currentThread().getName() + "已经获取到锁");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    System.out.println(Thread.currentThread().getName() + "睡眠期间被打断");
                }
            } finally {
                reentrantLock.unlock();
                System.out.println();
            }
        } catch (InterruptedException e) {
            System.out.println("获得锁期间被打断");
        }
    }
}
