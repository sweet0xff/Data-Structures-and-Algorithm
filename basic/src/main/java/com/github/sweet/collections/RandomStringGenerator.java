package com.github.sweet.collections;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/**
 * @author sweet
 * @description 随机序列生成器
 * @date 2021/4/2 21:21
 */
public class RandomStringGenerator<T> implements Iterable<T> {

    private final List<T> list;

    public RandomStringGenerator(List<T> list) {
        this.list = list;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            @Override
            public boolean hasNext() {
                return true;
            }

            @Override
            public T next() {
                return list.get((int) (list.size() * Math.random()));
            }
        };
    }

    public static void main(String[] args) {
        List<String> strings = Arrays.asList("111", "222", "333");
        RandomStringGenerator<String> generator = new RandomStringGenerator<>(strings);
        System.out.println(Runtime.getRuntime().availableProcessors());

        Iterator<String> iterator = generator.iterator();
        for (int i = 0; i < 100; i++) {
            System.out.println(iterator.next());
        }
    }
}
