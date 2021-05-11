package com.github.sweet.jvm01;

import sun.misc.Launcher;

import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.ArrayList;

/**
 * @author sweet
 * @description 显示当前 ClassLoader 加载了哪些jar
 * @date 2021/5/9 16:32
 */
public class JvmClassLoaderDemo {
    public static void main(String[] args) throws NoSuchFieldException {
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        System.out.println("打印启动类加载器：");
        for (URL url : urLs) {
            System.out.println("---> " + url.toExternalForm());
        }
        printClassLoader("打印扩展类加载器：", JvmClassLoaderDemo.class.getClassLoader().getParent());
        printClassLoader("打印应用类加载器：", JvmClassLoaderDemo.class.getClassLoader());
    }
    private static void printClassLoader(String str, ClassLoader classLoader) throws NoSuchFieldException {
        System.out.println("ClasaLoader: " + classLoader.toString());
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
