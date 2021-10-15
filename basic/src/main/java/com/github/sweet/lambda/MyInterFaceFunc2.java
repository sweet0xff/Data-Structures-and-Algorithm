package com.github.sweet.lambda;

/**
 * @author sweet
 * @description
 * @date 2021/10/15 10:30
 */
@FunctionalInterface
public interface MyInterFaceFunc2<T, K> {
    abstract K getValue(T t1, T t2);
}
