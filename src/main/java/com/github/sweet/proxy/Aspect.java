package com.github.sweet.proxy;

import com.github.sweet.monad.Try;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @description
 * @date 2021/4/4 21:17
 */
public interface Aspect {
    void before();
    void atfer();

    static <T> T getProxy(Class<T> cls, String ... aspects) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        List<Try<Aspect>> aspectsInst = Arrays.stream(aspects).map(name -> Try.ofFailable(() -> {
            Class<?> clazz = Class.forName(name);
            return (Aspect) clazz.getConstructor().newInstance();
        }))
                .filter(aspect -> aspect.isSuccess())
                .collect(Collectors.toList());

        T inst = cls.getConstructor().newInstance();
        return (T)Proxy.newProxyInstance(cls.getClassLoader(), cls.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                for (Try<Aspect> tryAspect : aspectsInst) {
                    tryAspect.get().before();
                }
                Object result = method.invoke(inst);
                for (Try<Aspect> tryAspect : aspectsInst) {
                    tryAspect.get().atfer();
                }
                return result;
            }
        });
    }
}
