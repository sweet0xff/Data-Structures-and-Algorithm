package com.github.sweet.jvm02;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author sweet
 * @description
 * @date 2021/5/9 15:21
 */
public class XlassLoader extends ClassLoader{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        String fileName = "Hello";
        String methodName = "hello";
        ClassLoader classLoader = new XlassLoader();
        Class<?> aClass = classLoader.loadClass(fileName);
        Method[] methods = aClass.getDeclaredMethods();
        for (int i = 0; i < methods.length; i++) {
            System.out.println(aClass.getSimpleName() + "." + methods[i].getName());
        }
        Object obj = aClass.getDeclaredConstructor().newInstance();
        Method method = aClass.getMethod(methodName);
        method.invoke(obj);
    }

    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        String path = this.getClass().getClassLoader().getResource("").getPath();
        String packageName = "com.github.sweet.jvm0104";
        String resourceName = packageName.replace(".", "/");
        String fullPath = path + resourceName + "/" + name +  ".xlass";
        InputStream inputStream = null;
        try {
            inputStream = new FileInputStream(fullPath);
            int length = inputStream.available();
            byte[] bytes = new byte[length];
            inputStream.read(bytes);
            byte[] classBytes = decode(bytes);
            return defineClass(name, classBytes, 0, classBytes.length);
        } catch (IOException e) {
            throw new ClassNotFoundException(name, e);
        } finally {
            if (null != inputStream) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    // 解码, Hello.class 的文件是所有字节（x=255-x）经处理后的文件
    private static byte[] decode(byte[] byteArray) {
        byte[] targetArray = new byte[byteArray.length];
        for (int i = 0; i < byteArray.length; i++) {
            targetArray[i] = (byte) (255 - byteArray[i]);
        }
        return targetArray;
    }
}
