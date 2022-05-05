package com.github.sweet.concurrency.flowcontrol;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author sweet
 * @description
 * @date 2021/11/2 16:09
 */
public class SemaphoreDemo {
    static Semaphore semaphore = new Semaphore(5);
    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(100);

        for (int i = 0; i < 100; i++) {
            service.submit(() -> {
                try {
                    semaphore.acquire(3);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 拿到许可");
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " 释放许可");
                semaphore.release(3);
            });
        }
        service.shutdown();
    }
}
