package com.github.sweet.annotation;

import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @description
 * @date 2021/4/5 16:21
 */
public class AnnotationTest {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {
        IOrder order = ObjectFactory.newInstance(Order.class);
        order.pay();
        order.show();
        AtomicInteger a = new AtomicInteger();
    }
}
