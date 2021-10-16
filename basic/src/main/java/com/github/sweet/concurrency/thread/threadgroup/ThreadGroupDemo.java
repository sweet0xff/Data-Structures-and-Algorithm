package com.github.sweet.concurrency.thread.threadgroup;

import java.util.Arrays;

/**
 * @author sweet
 * @description
 * @date 2021/10/12 17:44
 */
public class ThreadGroupDemo {
    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("test");
        });
        thread.start();
        System.out.println("thread group " + thread.getThreadGroup());
        System.out.println("Thread group " + Thread.currentThread().getThreadGroup());
        System.out.println(Thread.currentThread().getThreadGroup().activeCount());
        Thread[] threads = new Thread[Thread.currentThread().getThreadGroup().activeCount()];
        Thread.currentThread().getThreadGroup().enumerate(threads);
        Arrays.asList(threads).forEach(System.out::println);
    }
}
