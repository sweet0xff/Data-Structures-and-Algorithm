package com.github.sweet.collections.stream;

import java.util.stream.Stream;

/**
 * @author
 * @description
 * @date 2021/4/15 13:42
 */
public class StreamDemo {
    public static void main(String[] args) {
        var stream = Stream.of("1", "2", "3", "4")
                .map(Integer::valueOf)
                .reduce(Math::max);
//        Optional<Integer> x = Optional.empty();
//        Optional<Integer> y = Optional.of(x.map(a -> a + a).orElse(Integer.valueOf(1)));
//        System.out.println(y.get());

    }
}
