package com.github.sweet.concurrency.singleton;

/**
 * @author sweet
 * @description 同步代码块，不可用，if 那里会存在多个线程同时到达
 * @date 2021/10/8 14:57
 */
public class Singleton5 {
    private static Singleton5 instance;

    public Singleton5() {
    }

    public static Singleton5 getInstance() {
        if (null == instance) {
            synchronized (Singleton5.class) {
                instance = new Singleton5();
            }
        }
        return instance;
    }
}
