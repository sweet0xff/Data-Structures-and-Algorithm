package com.github.sweet.concurrency.lock.unlock;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sweet
 * @description
 * @date 2021/10/9 09:35
 */
public class TryLock01 {
    static Lock lock1 = new ReentrantLock();
    static Lock lock2 = new ReentrantLock();

    public static void main(String[] args) {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println("线程1拿到了锁1");
                            Thread.sleep(new Random().nextInt(1000));
                            if (lock2.tryLock(800, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println("线程1拿到了锁2");
                                    System.out.println("线程1同时拿到了锁1,2");
                                    break;
                                } finally {
                                    lock2.unlock();
                                    Thread.sleep(new Random().nextInt(1000));
                                }
                            } else {
                                System.out.println("线程1锁2获取失败");
                            }
                        } finally {
                            lock1.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        System.out.println("线程1锁1获取失败, 以重试");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }).start();


        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                try {
                    if (lock2.tryLock(3000, TimeUnit.MILLISECONDS)) {
                        try {
                            System.out.println("线程2拿到了锁2");
                            Thread.sleep(new Random().nextInt(1000));
                            if (lock1.tryLock(800, TimeUnit.MILLISECONDS)) {
                                try {
                                    System.out.println("线程2拿到了锁1");
                                    System.out.println("线程2同时拿到了锁2,1");
                                    break;
                                } finally {
                                    lock1.unlock();
                                    Thread.sleep(new Random().nextInt(1000));
                                }
                            } else {
                                System.out.println("线程2锁1获取失败");
                            }
                        } finally {
                            lock2.unlock();
                            Thread.sleep(new Random().nextInt(1000));
                        }
                    } else {
                        System.out.println("线程2锁2获取失败");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
