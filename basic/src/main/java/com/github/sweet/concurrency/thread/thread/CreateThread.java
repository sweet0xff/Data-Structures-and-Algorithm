package com.github.sweet.concurrency.thread.thread;

/**
 * @author
 * @description 创建线程的方式
 * @date 2021/10/15 09:20
 */
public class CreateThread {
    public static void main(String[] args) {
        //lambda写法
        Runnable runnable = () -> System.out.println("debug");
        new Thread(runnable).start();
        new Thread(() -> System.out.println("debug")).start();

        Runnable run2 = new Runnable() {
            @Override
            public void run() {
                System.out.println("debug");
            }
        };
        new Thread(run2).start();

        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
            }
        };

        thread.start();
    }
}
