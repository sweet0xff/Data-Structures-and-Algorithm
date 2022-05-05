package com.github.sweet.collections;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @description
 * @date 2021/11/30 15:49
 */
public class SortDemo {
    public static void main(String[] args) {
        String[] set = {"aaa", "fff", "eee", "ddd"};
        List<String> list = Arrays.asList(set);
        Collections.sort(list, String::compareTo);
//        Stream.of(list).forEach(System.out::println);
        int[] nums = {3, 2, 1, 5, 6, 4};
        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, (Comparator) (o1, o2) -> (Integer) o1 > (Integer)o2 ? -1 : 1);
//        Stream.of(integers).forEach(System.out::println);
//        System.out.println(integers[2]);
        Arrays.sort(nums);
        PriorityQueue<Integer> pq = new PriorityQueue((o1, o2) -> (Integer)o2 > (Integer) o1 ? 1 : -1);
        int[] nums2 = {1, 3, 9, 5, 8, 6};
        int index = 2;
        for (int i = 0; i < nums2.length; i++) {
            pq.offer(nums2[i]);
//            if (pq.size() > index) {
//                pq.poll();
//            }
        }
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.poll());
    }
}
