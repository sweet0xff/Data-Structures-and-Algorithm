package com.github.sweet.proxy.reflect;

import java.lang.reflect.InvocationTargetException;

/**
 * @description
 * @date 2021/4/5 10:35
 */
public class ProxyExampleTest {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, InterruptedException {
        IOrder order = Aspect.getProxy(Order.class, "com.github.sweet.proxy.TimeUsageAspect");
        order.pay();
        order.show();
    }
}
