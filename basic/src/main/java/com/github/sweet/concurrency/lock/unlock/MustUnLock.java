package com.github.sweet.concurrency.lock.unlock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author sweet
 * @description
 * @date 2021/10/9 09:09
 */
public class MustUnLock {
    static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        lock.lock();
        try {
            System.out.println(Thread.currentThread().getName());
        } catch (Exception e) {
            System.out.println(e);
        } finally {
            lock.unlock();
        }
    }
}
