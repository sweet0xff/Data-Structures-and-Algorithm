package com.github.sweet.proxy.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.LinkedList;

/**
 * @description
 * @date 2021/4/5 15:37
 */
public class ObjectFactory {

    public static <T> T newInstance(Class<T> clazz) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Annotation[] clazzs = clazz.getAnnotations();
        LinkedList aspectList = new LinkedList<IAspect>();

        for (Annotation annotation: clazzs) {
            if (annotation instanceof Aspect) {
                Class aspectClass = ((Aspect) annotation).type();
                IAspect aspect = (IAspect) aspectClass.getConstructor().newInstance();
                aspectList.push(aspect);
            }
        }

        T inst = clazz.getConstructor().newInstance();
        return (T)Proxy.newProxyInstance(clazz.getClassLoader(), clazz.getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws InvocationTargetException, IllegalAccessException {
                aspectList.forEach(aspect -> {
                    IAspect iAspect =(IAspect) aspect;
                    iAspect.before();
                });
                Object result = method.invoke(inst);
                aspectList.forEach(aspect -> {
                    IAspect iAspect =(IAspect) aspect;
                    iAspect.atfer();
                });
                return result;
            }
        });
    }
}
