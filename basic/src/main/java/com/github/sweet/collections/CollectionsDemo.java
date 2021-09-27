package com.github.sweet.collections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author sweet
 * @description
 * @date 2021/9/27 13:26
 */
public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(99);
        list.add(4);
        list.add(8);
        list.add(10);
        Collections.sort(list);
//        for (Integer i : list) {
//            System.out.println(i);
//        }
        Collections.sort(list, (o1, o2) -> o2.compareTo(o1));
//        for (Integer i: list) {
//            System.out.println(i);
//        }
        Collections.sort(list, Collections.reverseOrder());

        System.out.println(Collections.min(list));
        System.out.println(Collections.max(list));
        System.out.println(Collections.max(Arrays.asList("11", "222", "33")));
    }
}
