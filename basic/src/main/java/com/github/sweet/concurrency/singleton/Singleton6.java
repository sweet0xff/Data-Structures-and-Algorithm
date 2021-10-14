package com.github.sweet.concurrency.singleton;

/**
 * @author sweet
 * @description 双重检查,推荐使用，但是指令重排序导致 NPE，所以可以➕ volatile 解决，保证 happens-before
 * @date 2021/10/8 14:57
 */
public class Singleton6 {
    private static volatile Singleton6 instance;

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
        return Singleton6.instance;
    }
}
