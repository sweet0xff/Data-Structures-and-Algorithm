package com.github.sweet.concurrency.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author sweet
 * @description
 * @date 2021/10/9 16:06
 */
public class AtomicIntegerDemo {
    private int a;

    {
        System.out.println("代码块");
    }

    static {
        System.out.println("静态代码块");
    }

    public AtomicIntegerDemo() {
        System.out.println("无参构造");
    }

    public AtomicIntegerDemo(int a) {
        System.out.println("有参数构造");
        this.a = a;
    }

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger();
        AtomicIntegerDemo demo = new AtomicIntegerDemo(1);
    }
}
