package com.github.zengge95;

import java.util.Arrays;

/**
 * 实现一个动态扩容的数组
 */
public class DynamicArray<E> {

    private static final int DEFAULT_CAPACITY = 10; //默认长度 10
    private int size;
    private Object[] element;

    public DynamicArray(){
        this.element = new Object[DEFAULT_CAPACITY];
    }

    //实现动态扩容，若长度不够，则乘以2
    private void ensureCapacity(int minCapacity){
        int oldCaptcity = element.length;
        if (oldCaptcity > minCapacity){
            return;
        }
        int newCapacity = oldCaptcity * 2;
        if (newCapacity < minCapacity){
            newCapacity = minCapacity;
            element = Arrays.copyOf(element,newCapacity); //通过拷贝原数组，生成新的数组
        }
    }

    public void add(E e){
        ensureCapacity(size + 1);
        element[size++] = e;
    }

    public E get(int index){
        return (E)element[index];
    }

    public void set(int index, E newElement){
        element[index] = newElement;
    }
}
