package com.github.zengge95.collections;

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
            System.out.println(iterator.next());
        }



        List<Integer> listdemo = new ArrayList<>();
        System.out.println("listDemo 的 size 为：" + listdemo.size());
        System.out.println("list 的 size 为：" + list.size());
    }

}
