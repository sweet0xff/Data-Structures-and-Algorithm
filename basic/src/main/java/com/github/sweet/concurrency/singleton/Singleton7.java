package com.github.sweet.concurrency.singleton;

/**
 * @author sweet
 * @description 静态内部类，推荐，static final由JVM保证完整初始化流程，不会出现NPE
 * @date 2021/10/8 14:57
 */
public class Singleton7 {
    private static class SingletonInstance{
        private final static Singleton7 instance = new Singleton7();
    }

    public Singleton7() {
    }

    public static Singleton7 getInstance() {
        return SingletonInstance.instance;
    }
}
