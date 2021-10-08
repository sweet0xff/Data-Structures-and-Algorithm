package com.github.sweet.concurrency.singleton;

/**
 * @author sweet
 * @description 同步方法，不推荐，效率比较低
 * @date 2021/10/8 14:57
 */
public class Singleton4 {
    private static Singleton4 instance;

    public Singleton4() {
    }

    public synchronized static Singleton4 getInstance() {
        if (null == instance) {
            instance = new Singleton4();
        }
        return instance;
    }
}
