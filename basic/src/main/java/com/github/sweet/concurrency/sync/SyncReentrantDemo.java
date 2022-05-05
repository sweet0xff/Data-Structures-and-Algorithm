package com.github.sweet.concurrency.sync;

/**
 * @author sweet
 * @description synchronized 是可重入锁
 * @date 2021/10/20 17:39
 */
public class SyncReentrantDemo {
    public static final Object object = new Object();

    public static void main(String[] args) {
        synchronized (object) {
            s1();
            synchronized (object) {
                s2();
            }
        }
    }
    public static void s1() {
        System.out.println("s1");
    }

    public static void s2() {
        System.out.println("s2");
    }
}

