package com.github.sweet.collections;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

/**
 * @author sweet
 * @description
 * @date 2021/9/26 11:20
 */
public class HashMapSizeAndCapacity {
    public static void main(String[] args) throws Exception {
        HashMap<Object, Object> hashMap = new HashMap<>();
        hashMap.put("test", "111");
        Class<? extends HashMap> clazz = hashMap.getClass();
        Method capacity = clazz.getDeclaredMethod("capacity");
        capacity.setAccessible(true);
        System.out.println("capacity: " + capacity.invoke(hashMap));

        Field size = clazz.getDeclaredField("size");
        size.setAccessible(true);
        System.out.println("size: " + size.get(hashMap));

    }
}
