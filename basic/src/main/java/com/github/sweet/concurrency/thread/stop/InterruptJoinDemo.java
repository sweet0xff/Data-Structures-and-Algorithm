package com.github.sweet.concurrency.thread.stop;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author
 * @description
 * @date 2021/10/13 10:24
 */
public class InterruptJoinDemo {
    public static void main(String[] args) throws InterruptedException {
        Thread t0 = new Thread(() -> {
            while (true) {
            }
        });
        t0.start();

        Thread mainThread = Thread.currentThread();
        Thread t1 = new Thread(() -> {
            //1. 因为t0.join() 后面的代码会等待t0执行完，所以这里要演示中断流程需要写在t0.join之前
            //2. t0.interrupt()并不生效，并不会打断t0，因为进入等待的是main 线程，如果要进入 catch，需要打断main线程
            //3. sleep wait 都是当前线程进入等待，所以可以调用当前线程的 interrupt方法
            mainThread.interrupt();
        });
        t1.start();
        try {
            t0.join(); //main线程进入block
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("main interrupt");
        }
    }
}
