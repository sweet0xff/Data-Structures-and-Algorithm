package com.github.sweet.concurrency.singleton;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * @author sweet
 * @description 枚举 推荐
 * @date 2021/10/8 14:57
 */
public class Singleton8 {
    public Singleton8() {
    }

    private enum Singleton {
        INSTANCE;

        private final Singleton8 instance;

        Singleton() {
            instance = new Singleton8();
        }
        public Singleton8 getInstance() {
            return instance;
        }
    }

    public static Singleton8 getInstance() {
        return Singleton.INSTANCE.getInstance();
    }

    //测试
    public static void main(String[] args) {
        IntStream.rangeClosed(1, 100)
                .forEach(i -> new Thread(String.valueOf(i)){
                    @Override
                    public void run() {
                        Optional.of(Singleton8.getInstance()).ifPresent(System.out::println);
                    }
                }.start());
    }
}
