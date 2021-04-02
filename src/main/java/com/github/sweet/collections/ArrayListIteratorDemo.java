package com.github.sweet.collections;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 比较索引遍历，迭代器遍历，for循环遍历三种方式的遍历效率
 */
public class ArrayListIteratorDemo {
    public static void main(String[] args) {
        List listDemo = new ArrayList();
        for (int i = 0; i < 1000000; i++) {
            listDemo.add(i);
        }

        iteratorThroughRandomAccess(listDemo);
        iteratorThroughIterator(listDemo);
        iteratorThroughForeach(listDemo);
    }

    private static void iteratorThroughRandomAccess(List list) {
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        endTime = System.currentTimeMillis();
        System.out.println("iteratorThroughRandomAccess 用时：" + (endTime - startTime) + "ms");
    }

    private static void iteratorThroughIterator(List list) {
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for (Iterator iter = list.iterator();
            iter.hasNext(); ) {
            iter.next();
        }
        endTime = System.currentTimeMillis();
        System.out.println("iteratorThroughIterator 用时：" + (endTime - startTime) + "ms");
    }

    private static void iteratorThroughForeach(List list){
        long startTime;
        long endTime;
        startTime = System.currentTimeMillis();
        for(Object obj:list){
            ;
        }
        endTime = System.currentTimeMillis();
        System.out.println("interatorThroughFOreach 用时：" + (endTime - startTime) + "ms");
    }
}
