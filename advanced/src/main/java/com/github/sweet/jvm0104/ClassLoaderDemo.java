package com.github.sweet.jvm0104;

import java.lang.reflect.Field;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * @author sweet
 * @description
 * @date 2021/5/9 16:32
 */
public class ClassLoaderDemo {
    public static void main(String[] args) throws NoSuchFieldException {
        printAppClassLoader();
    }
    private static void printAppClassLoader() throws NoSuchFieldException {
        ClassLoader classLoader = ClassLoaderDemo.class.getClassLoader();
        System.out.println(classLoader.toString());
        Object ucp = insightFiled(classLoader, "ucp");
        Object path = insightFiled(ucp, "path");
        ArrayList ps = (ArrayList) path;
        for (Object p: ps) {
            System.out.println("--> " + p.toString());
        }
    }

    private static Object insightFiled(Object object, String fName) throws NoSuchFieldException {
        Field field;
        if (object instanceof URLClassLoader) {
            field = URLClassLoader.class.getDeclaredField(fName);
        } else {
            field = object.getClass().getDeclaredField(fName);
        }
        field.setAccessible(true);
        try {
            return field.get(object);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }
}
