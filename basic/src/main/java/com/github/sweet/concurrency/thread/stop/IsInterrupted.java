package com.github.sweet.concurrency.thread.stop;

/**
 * @author sweet
 * @description
 * @date 2021/9/29 16:47
 */
public class IsInterrupted implements Runnable {
    @Override
    public void run() {
        for (; ; ) {
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new IsInterrupted());
        thread.start();
        Thread.sleep(1000);
        System.out.println(thread.isInterrupted());
        System.out.println(Thread.interrupted());
        thread.interrupt();
        System.out.println(thread.isInterrupted());
        System.out.println(Thread.interrupted());
    }
}
