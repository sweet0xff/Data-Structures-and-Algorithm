package com.github.sweet.concurrency.thread.sleep;

import java.util.stream.Stream;

/**
 * @author
 * @description
 * 1. wait 是Object方法，sleep 是Thread方法
 * 2. wait 会释放monitor,sleep 不会
 * 3. wait 依赖 monitor(synchronized), sleep不会
 * 4 wait需要 wakeup, sleep 不需要
 * @date 2021/10/13 16:51
 */
public class WaitAndSleepDiff {
    private final static Object lock = new Object();

    public static void main(String[] args) {
        Stream.of("t0", "t1").forEach(t -> {
            new Thread(t){
                @Override
                public void run() {
//                    m1();
                    m2();
                }
            }.start();
        });
    }

    public static void m1() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " m1");
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void m2() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " m2");
                lock.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
