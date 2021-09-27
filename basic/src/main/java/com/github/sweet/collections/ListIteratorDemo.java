package com.github.sweet.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * @author sweet
 */
public class ListIteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(3);
//        Iterator iterator = list.iterator();
//        while (iterator.hasNext()) {
        // 调用 remove 方法之前一定要调用 next() 方法
//            if (iterator.next().equals(2)) {
//                iterator.remove();
//            }
//        }

        Iterator iterator1 = list.iterator();
        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        System.out.println("list 的 size 为：" + list.size());

        List<Integer> list2 = new ArrayList<>();
        System.out.println("listDemo 的 size 为：" + list2.size());

        ArrayList<Object> list3 = new ArrayList<>(10);
        //Exception in thread "main" java.lang.IndexOutOfBoundsException: Index: 1, Size: 0
        //list3.add(2, "222");

        List<String> list4 = new ArrayList<String>(Collections.nCopies(9, "a"));
        System.out.println("初始化：" + list4);
        list4.add(2, "b");
        System.out.println("插入后：" + list4);
    }

}
