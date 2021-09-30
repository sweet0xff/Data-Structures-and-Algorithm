package com.github.sweet.concurrency.thread.waitandnotify;

/**
 * @author sweet
 * @description
 * @date 2021/9/29 20:54
 */
public class WaitNotifyReleaseOwnMonitor {
    static final Object object1 = new Object();
    static final Object object2 = new Object();
    public static void main(String[] args) throws InterruptedException {
        Thread thread0 = new Thread(() -> {
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + " 拿到了 object1 锁");
                synchronized (object2) {
                    System.out.println(Thread.currentThread().getName() + " 拿到了 object2 锁");
                    try {
                        System.out.println(Thread.currentThread().getName() + " wait 释放object1锁");
                        object1.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("end");
                }
            }
        });

        Thread thread1 = new Thread(() -> {
            synchronized (object1) {
                System.out.println(Thread.currentThread().getName() + " 拿到 object1 锁");
                System.out.println(Thread.currentThread().getName() + " 尝试拿到 object2 锁");
                synchronized (object2) {
                    System.out.println(Thread.currentThread().getName() + " 拿到了 object2锁");
                }
            }
        });

        thread0.start();
        Thread.sleep(1000);
        thread1.start();
    }
}
