package com.github.sweet.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author sweet
 * @description
 * @date 2021/10/18 20:52
 */
public class OutputStreamDemo {
    public static void main(String[] args) throws Exception {
        FileOutputStream fileOutputStream = new FileOutputStream("a.txt", true);
        //[-28, -67, -96, -27, -91, -67]
        System.out.println(Arrays.toString("你好".getBytes(StandardCharsets.UTF_8)));
        System.out.println(new String("你好".getBytes(StandardCharsets.UTF_8)));

        fileOutputStream.write("你好".getBytes(StandardCharsets.UTF_8));
        fileOutputStream.close();

        FileReader fileReader = new FileReader("a.txt");
        int len = 0;
//        读取单个字符并返回
        while ((len = fileReader.read()) != -1) {
            System.out.println((char) len);
        }
        fileReader.close();
//        char[] chars = new char[1024];
//        int len1 = 0; //记录每次读取的有效个数
//        while ((len1 = fileReader.read(chars)) != -1) {
//            System.out.println(new String(chars, 0, len1));
//        }
        fileReader.close();
    }
}
