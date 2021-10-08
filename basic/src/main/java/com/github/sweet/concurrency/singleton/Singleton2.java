package com.github.sweet.concurrency.singleton;

/**
 * @author sweet
 * @description 静态代码块
 * @date 2021/10/8 14:52
 */
public class Singleton2 {
    private static Singleton2 instance;

    public Singleton2() {
    }

    static {
        instance = new Singleton2();
    }

    public static Singleton2 getInstance() {
        return instance;
    }
}
