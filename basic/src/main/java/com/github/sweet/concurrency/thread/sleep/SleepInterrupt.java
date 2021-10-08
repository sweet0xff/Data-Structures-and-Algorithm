package com.github.sweet.concurrency.thread.sleep;

import java.util.concurrent.TimeUnit;

/**
 * @author sweet
 * @description
 * @date 2021/9/30 15:12
 */
public class SleepInterrupt implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        SleepInterrupt sleepInterrupt = new SleepInterrupt();
        Thread thread = new Thread(sleepInterrupt);
        thread.start();
        TimeUnit.SECONDS.sleep(3);
        thread.interrupt();
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(i);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("我被中断了");
                e.printStackTrace();
            }
        }
    }
}
