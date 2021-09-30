package com.github.sweet.concurrency.thread.waitandnotify;

/**
 * @author sweet
 * @description wait notify 实现奇偶交替打印
 * @date 2021/9/30 14:02
 */
public class WaitNotifyPrintEvenOdd{
    private static int count = 0;
    private static Object object = new Object();

    static class TestThread implements Runnable {
        @Override
        public void run() {
            while (count < 100) {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + count++);
                    object.notify();
                    if (count < 100) {
                        try {
                            object.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new TestThread(), "偶数").start();

        new Thread(new TestThread(), "奇数").start();
    }
}
