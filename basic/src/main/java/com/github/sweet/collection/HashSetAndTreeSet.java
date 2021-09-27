package com.github.sweet.collection;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author sweet
 * @description
 * @date 2021/9/25 11:17
 */
public class HashSetAndTreeSet {
    public static void main(String[] args) {
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(8);
        hashSet.add(3);
        hashSet.add(23);
        hashSet.add(7);

        Iterator<Integer> iterator = hashSet.iterator();
        while (iterator.hasNext()) {
            System.out.println("h: " + iterator.next());
        }
        System.out.println(hashSet.stream().map(x -> x.toString()).collect(Collectors.joining(",")));

        Integer a = 5;
        TreeSet<Integer> treeSet = new TreeSet<Integer>(){
            {
                add(a);
                add(3);
                add(4);
                add(33);
                add(9);
                add(5);
            }
        };
        System.out.println(treeSet.lower(a));
        System.out.println(treeSet.higher(a));
        System.out.println(treeSet.ceiling(a));
        System.out.println(treeSet.floor(a));
        System.out.println(treeSet.stream().map(x -> x.toString()).collect(Collectors.joining(",")));

        Map map = new HashMap(32);
    }
}

