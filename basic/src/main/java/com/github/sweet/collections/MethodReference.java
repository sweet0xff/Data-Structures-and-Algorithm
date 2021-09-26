package com.github.sweet.collections;

import java.util.ArrayList;

/**
 * @author sweet
 * @description
 * @date 2021/9/25 10:34
 */
public class MethodReference {
    public static void main(String[] args) {
        ArrayList<String> arr = new ArrayList<>();
        arr.stream().toArray(String[]::new);
    }
}
