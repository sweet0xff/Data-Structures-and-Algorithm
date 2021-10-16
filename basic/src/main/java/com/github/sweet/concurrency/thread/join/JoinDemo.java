package com.github.sweet.concurrency.thread.join;

/**
 * @author
 * @description
 * @date 2021/10/13 09:31
 */
public class JoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(() -> {
            System.out.println("t0 is running");
            try {
                Thread.sleep(5000);
                System.out.println("t0 is end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t0.start();
        t0.join(2000);

        System.out.println("main is start");

    }
}
