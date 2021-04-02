package com.github.sweet.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ListIteratorDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(3);
        Iterator iterator = list.iterator(); // 迭代器用法

        while (iterator.hasNext()) {
            if (iterator.next().equals(2)) { // 调用 remove 方法之前一定要调用 next() 方法
                iterator.remove();
            }
        }

        Iterator iterator1 = list.iterator();

        while (iterator1.hasNext()) {
            System.out.println(iterator1.next());
        }

        List<Integer> listdemo = new ArrayList<>();
        System.out.println("listDemo 的 size 为：" + listdemo.size());
        System.out.println("list 的 size 为：" + list.size());
    }

}
