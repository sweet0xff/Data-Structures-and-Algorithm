package com.github.sweet.concurrency.flowcontrol;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sweet
 * @description
 * @date 2021/11/3 09:39
 */
public class CountDownLatchDemo1 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int j = i;
            service.submit(() -> {
                try {
                    Thread.sleep((long) (Math.random() * 10000));
                    System.out.println("第" + j + "个人干完了活");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    countDownLatch.countDown();
                }
            });
        }

        System.out.println("等五个人都干完活");
        countDownLatch.await();
        System.out.println("所有人已干完活");
        service.shutdown();
    }
}
