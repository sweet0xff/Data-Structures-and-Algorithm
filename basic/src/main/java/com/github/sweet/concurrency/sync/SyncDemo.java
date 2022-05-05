package com.github.sweet.concurrency.sync;

import java.time.format.DateTimeFormatter;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @description 线程八锁的问题
 * @date 2021/10/16 12:15
 */
public class SyncDemo {
    public static void main(String[] args) {
        Person person = new Person();
        new Thread(() -> {
            //两把锁
            person.b();
            Person.a();
        }).start();
        ReentrantLock reentrantLock = new ReentrantLock();
    }

}
class Person {
    public static synchronized void a () {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("1");
    }

    public synchronized void b () {
        System.out.println("2");
    }
}
