package com.github.sweet.concurrency;

import java.util.concurrent.ConcurrentHashMap;

/**
 * @author
 * @description b d 因为有final修饰，编译期间就确定了，和a一样，指向常量池。e运行时才确定， 指向堆
 * d == a
 * e != a
 * g != a
 * @date 2021/10/9 20:44
 */
public class FinalString {
    public static void main(String[] args) {
        new ConcurrentHashMap();
        String a = "xxx2";
        final String b = "xxx";
        String c = "xxx";
        String d = b + "2";
        String e = c + "2";
        System.out.println(d == a);
        System.out.println(e == a);

        final String f = getString();
        String g = f + "2";
        System.out.println(g == a);
    }

    private static String getString() {
        return "xxx";
    }
}
