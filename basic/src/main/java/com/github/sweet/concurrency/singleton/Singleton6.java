package com.github.sweet.concurrency.singleton;

/**
 * @author sweet
 * @description 双重检查,推荐使用
 * @date 2021/10/8 14:57
 */
public class Singleton6 {
    private static Singleton6 instance;

    public Singleton6() {
    }

    public static Singleton6 getInstance() {
        if (null == instance) {
            synchronized (Singleton6.class) {
                if (null == instance) {
                    instance = new Singleton6();
                }
            }
        }
        return instance;
    }
}
