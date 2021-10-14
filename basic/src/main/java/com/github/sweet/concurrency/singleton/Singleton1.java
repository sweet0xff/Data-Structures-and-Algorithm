package com.github.sweet.concurrency.singleton;

/**
 * @author sweet
 * @description 静态常量法，can not lazy load
 * @date 2021/10/8 14:51
 */
public class Singleton1 {
    private final static Singleton1 INSTANCE = new Singleton1();

    public Singleton1() {
    }

    public static Singleton1 getSingleton() {
        return INSTANCE;
    }
}
