package com.github.sweet.stream;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author
 * @description 创建流的方式
 * @date 2021/10/15 13:09
 */
public class CreateStream {
    public static void main(String[] args) {
        //1. Collection集合的 stream() 或者 parallelStream()
        Stream<Object> stream1 = new ArrayList<>().stream();
        Stream<Object> parallelStream = new ArrayList<>().parallelStream();

        //Arrays 的静态方法 stream() 获取数组流
        Stream<Object> stream2 = Arrays.stream(new Object[10]);

        //Stream的静态方法 of()
        Stream<String> stream3 = Stream.of("aa", "bb", "cc");
        stream3.map(String::toUpperCase).forEach(System.out::println);

        //创建无限滚动流
        Stream<Integer> stream4 = Stream.iterate(0, x -> x + 2);
//        stream4.forEach(System.out::println);

        //生成流
        Stream<Double> stream5 = Stream.generate(() -> Math.random());
        stream5.limit(10).forEach(System.out::println);

    }
}
