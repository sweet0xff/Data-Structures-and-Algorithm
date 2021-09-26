package com.github.sweet.sorting;

import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author sweet
 * @description
 * @date 2021/9/25 18:47
 */
public class SortTests {

    @Test
    public void test_InsertionSort() {
        sortTest(InsertionSort.class, 100);
    }

    public void sortTest(Class cls, int N) {
        try {
            Constructor constructor = cls.getConstructor();
            Object instance = constructor.newInstance();
            long start = System.currentTimeMillis();
            if (instance instanceof IMutableSorter) {
                int[] intArr = gen(N).stream().mapToInt(x -> x).toArray();
                IMutableSorter inst = (IMutableSorter)instance;
                inst.sort(intArr);
                assertSorted(intArr);
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    static void assertSorted(int[] A) {
        System.out.println(Arrays.stream(A).boxed().collect(Collectors.toList()));
        assertSorted(Arrays.stream(A).boxed().collect(Collectors.toList()));
    }

    static void assertSorted(List<Integer> A) {
        Integer o = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            if (o > A.get(i)) {
                Assert.fail("sort failed");
            }
            o = A.get(i);
        }
    }

    static List<Integer> gen(int n) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add((int) (Math.random() * n));
        }
        return list;
    }
}
