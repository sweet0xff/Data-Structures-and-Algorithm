package com.github.sweet.concurrency.thread.waitandnotify;

/**
 * @author sweet
 * @description
 * @date 2021/9/29 19:53
 */
public class WaitAndNotify {
    static final Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + " 开始执行wait: ");
                try {
                    object.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 重新获得锁");
            }
        });

        Thread thread2 = new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + " object唤醒.");
                object.notify();
            }
        });

        thread1.start();
        Thread.sleep(1000);
        thread2.start();
    }
}
