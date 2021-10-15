package com.github.sweet.lambda;

/**
 * @author
 * @description
 * @date 2021/10/15 10:07
 */
public class TestMyInterFaceFunc {
    public static void main(String[] args) {
        System.out.println(operation1(10, x -> x * x));
        System.out.println(operation2(23, 24, (x, y) -> x + y));
    }

    static int operation1(int num, MyInterFaceFunc1 myInterFaceFun) {
        return myInterFaceFun.get(num);
    }

    static Integer operation2(int num1, int num2, MyInterFaceFunc2<Integer, Integer> myInterFaceFun) {
        return myInterFaceFun.getValue(num1, num2);
    }
}
