package com.github.sweet.concurrency.flowcontrol;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sweet
 * @description
 * @date 2021/11/3 09:46
 */
public class CountDownLatchDemo2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int j = i;
            service.submit(() -> {
                System.out.println(j + "准备好了，等口号");
                try {
                    Thread.sleep((long) (Math.random() * 1000));
                    countDownLatch.await();
                    System.out.println(j + "听到口号，开始跑步");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        service.shutdown();

        Thread.sleep(5000);
        System.out.println("喊口号");
        countDownLatch.countDown();
    }
}
