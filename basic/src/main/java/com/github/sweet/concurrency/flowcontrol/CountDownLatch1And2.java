package com.github.sweet.concurrency.flowcontrol;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author sweet
 * @description 五个人等发令枪响开始跑步，跑完计时员宣布所有人跑步结束
 * @date 2021/11/3 09:53
 */
public class CountDownLatch1And2 {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch begin = new CountDownLatch(1);
        CountDownLatch end = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 5; i++) {
            int j = i;
            service.submit(() -> {
                System.out.println(j + "准备好了等口号");
                try {
                    Thread.sleep(500);
                    begin.await();
                    System.out.println(j + "开始跑步");
                    Thread.sleep(2000);
                    System.out.println(j + "跑步结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    end.countDown();
                }
            });
        }
        service.shutdown();

        Thread.sleep(1000);
        System.out.println("喊口号");
        begin.countDown();
        end.await();
        System.out.println("所有人跑步结束");
    }
}
