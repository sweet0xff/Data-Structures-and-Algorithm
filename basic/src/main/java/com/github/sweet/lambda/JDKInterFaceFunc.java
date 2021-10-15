package com.github.sweet.lambda;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author sweet
 * @description JDK 内置四大函数式接口
 * Consumer<T> : 消费型接口
 * void accept(T t);
 * <p>
 * Supplier<T> : 供给型接口
 * T get();
 * <p>
 * Function<T, R>: 函数型接口
 * R apply<T t>;
 * <p>
 * Predicate<T>: 断言型接口
 * boolean test(T t);
 * @date 2021/10/15 10:46
 */
public class JDKInterFaceFunc {

    public static void main(String[] args) {
        //消费型接口
        test1(100, (x) -> System.out.println("消费" + x));

        //产生指定个数的整数，放入集合返回
        List<Integer> list1 = test2(10, () -> (int) (Math.random() * 10));
        list1.stream().forEach(System.out::println);

        //处理字符串并返回
        System.out.println(test3("skdjalgj", (s) -> s.toUpperCase()));

        //过滤出满足条件的字符串，返回集合并返回
        List<String> list2 = Arrays.asList("sss", "s", "djlag", "djlagjdlge", "tttttttwww");
        List<String> test3 = test4(list2, (s) -> s.length() > 4);
        list2.stream().forEach(System.out::println);
    }

    static void test1(int num, Consumer<Integer> consumer) {
        consumer.accept(num);
    }

    static List<Integer> test2(int count, Supplier<Integer> supplier) {
        List list = new ArrayList<Integer>(10);
        for (int i = 0; i < count; i++) {
            list.add(supplier.get());
        }
        return list;
    }

    static String test3(String s, Function<String, String> func) {
        return func.apply(s);
    }

    static List<String> test4(List<String> list, Predicate<String> predicate) {
        List<String> list1 = new ArrayList<>();
        list.stream().forEach(s -> {
            if (predicate.test(s)) {
                list1.add(s);
            }
        });
        return list1;
    }
}
