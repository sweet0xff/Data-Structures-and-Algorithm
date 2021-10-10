package com.github.sweet.concurrency.lock.fairlock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @description 公平锁 非公平锁
 * @date 2021/10/9 13:22
 */
public class FairLock {
    public static void main(String[] args) {
        Waiting waiting = new Waiting();
        Thread [] threads = new Thread[10];
        for (int i = 0; i < 10; i++) {
            threads[i] = new Thread(new DoSomething(waiting));
        }
        for (int i = 0; i < 10; i++) {
            threads[i].start();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class DoSomething implements Runnable{
    private Waiting waiting;
    public DoSomething(Waiting waiting) {
        this.waiting = waiting;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始");
        waiting.printJob();
        System.out.println(Thread.currentThread().getName() + "干活完毕");
    }
}

class Waiting {
    private ReentrantLock reentrantLock = new ReentrantLock(true);
    public void printJob() {
        reentrantLock.lock();
        try {
            int duration = new Random().nextInt(10) + 1;
            System.out.println(Thread.currentThread().getName() + "正在干活，需要" + duration + "秒");
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }

        reentrantLock.lock();
        try {
            int duration = new Random().nextInt(10) + 1;
            System.out.println(Thread.currentThread().getName() + "正在干活，需要" + duration+"秒");
            Thread.sleep(duration * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            reentrantLock.unlock();
        }
    }
}