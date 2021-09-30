package com.github.sweet.concurrency.thread.waitandnotify;

/**
 * @author sweet
 * @description sync效果不高，会出现无效竞争
 * @date 2021/9/30 13:38
 */
public class SyncPrintEvenOdd {
    private static int count = 0;
    private static final Object object = new Object();

    public static void main(String[] args) {

        new Thread(() -> {
            while (true) {
                synchronized (object) {
                    if ((count & 1) == 0 && count < 100) {
                        System.out.println(Thread.currentThread().getName() + count++);
                    }
                }
            }
        }, "偶数").start();

        new Thread(() -> {
            while (true) {
                synchronized (object) {
                    if ((count & 1) == 1 && count < 100) {
                        System.out.println(Thread.currentThread().getName() + count++);
                    }
                }
            }
        }, "奇数").start();
    }
}
