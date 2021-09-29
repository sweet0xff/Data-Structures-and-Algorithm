package com.github.sweet.concurrency.cas;

import sun.misc.Unsafe;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicMarkableReference;
import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * @author sweet
 * @description
 * @date 2021/9/27 20:39
 */
public class CASDemo {
    public static void main(String[] args) {
        Unsafe s = Unsafe.getUnsafe();
        AtomicInteger i = new AtomicInteger();
        AtomicMarkableReference a = new AtomicMarkableReference(1, true);
        AtomicStampedReference b = new AtomicStampedReference(1, 1);
    }
}
