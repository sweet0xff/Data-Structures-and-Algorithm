package com.github.sweet.concurrency.thread.sleep;

/**
 * @author sweet
 * @description
 * @date 2021/9/30 14:34
 */
public class SleepDontReleaseMonitor implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        SleepDontReleaseMonitor sleepDontReleaseMonitor = new SleepDontReleaseMonitor();

        new Thread(sleepDontReleaseMonitor).start();
        new Thread(sleepDontReleaseMonitor).start();
    }

    @Override
    public void run() {
        syn();
    }

    private synchronized void syn() {
        System.out.println(Thread.currentThread().getName() + " 获取到锁");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " 释放锁");
    }


}
