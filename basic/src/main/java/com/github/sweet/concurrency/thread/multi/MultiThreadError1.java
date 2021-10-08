package com.github.sweet.concurrency.thread.multi;

import java.util.concurrent.TimeUnit;

/**
 * @author sweet
 * @description 多线程死锁
 * @date 2021/9/30 17:28
 */
public class MultiThreadError1 implements Runnable {
    int flag = 0;
    static Object object0 = new Object();
    static Object object1 = new Object();

    @Override
    public void run() {
        if (flag == 0) {
            System.out.println(Thread.currentThread().getName() + " flag0");
            synchronized (object0) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object1) {
                    System.out.println("这是flag0");
                }
            }
        }

        if (flag == 1) {
            System.out.println(Thread.currentThread().getName() + " flag1");
            synchronized (object1) {
                try {
                    TimeUnit.SECONDS.sleep(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object0) {
                    System.out.println("这是flag1");
                }
            }
        }
    }

    public static void main(String[] args) {
        MultiThreadError1 demo0 = new MultiThreadError1();
        demo0.flag = 0;
        MultiThreadError1 demo1 = new MultiThreadError1();
        demo1.flag = 1;
        new Thread(demo0).start();
        new Thread(demo1).start();
    }
}
