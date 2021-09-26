package com.github.sweet.sorting;

import java.util.ArrayList;

/**
 * @author sweet
 * @description
 * @date 2021/9/25 19:11
 */
public class InsertionSort2 {

    static void sort(int[] A) {
        for (int i = 1; i < A.length; i++) {
            // 将A[i] 插入在卡片0，到卡片i之间
            // j代表抓到的牌，先放到最右侧，不断交换到对应的位置
            int c = A[i];
            int j = i;

            for (; j > 0 && A[j - 1] > c; j--) {
                A[j] = A[j - 1];
            }
            A[j] = c;
        }
    }

    public static void main(String[] args) {
        int count = 100;
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            list.add((int) (Math.random() * count));
        }
        int[] A = list.stream().mapToInt(x -> x).toArray();
        for (int i : A) {
            System.out.print(i + ", ");
        }
        sort(A);
        System.out.println(" --- ");
        System.out.println(" --- ");
        for (int i : A) {
            System.out.print(i + ", ");
        }
    }
}
