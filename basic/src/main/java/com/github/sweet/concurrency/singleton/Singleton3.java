package com.github.sweet.concurrency.singleton;

/**
 * @author sweet
 * @description 线程不安全，不推荐使用
 * @date 2021/10/8 14:55
 */
public class Singleton3 {
    private static Singleton3 instance;

    public Singleton3() {
    }

    public static Singleton3 getInstance() {
        if (null == instance) {
            instance = new Singleton3();
        }
        return Singleton3.instance;
    }
}