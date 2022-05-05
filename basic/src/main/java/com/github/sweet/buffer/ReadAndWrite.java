package com.github.sweet.buffer;

import org.junit.Test;

import java.io.*;
import java.util.Random;

/**
 * @author sweet
 * @description
 * @date 2021/9/25 15:55
 */
public class ReadAndWrite {

    @Test
    public void gen() throws Exception {
        Random r = new Random();
        String fileName = "word.txt";
        int bufferSize = 4 * 1024;
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(fileName), bufferSize);

        long start = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            for (int j = 0; j < 5; j++) {
                bufferedOutputStream.write(97 + r.nextInt(5));
            }
            bufferedOutputStream.write(' ');
        }
        bufferedOutputStream.close();
        System.out.println(System.currentTimeMillis() - start);
    }

    @Test
    public void readFile() throws Exception {
        String fileName = "word.txt";
        FileInputStream fileInputStream = new FileInputStream(fileName);
        long start = System.currentTimeMillis();
        int b = 0;
        while ((b = fileInputStream.read()) != -1) {
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        fileInputStream.close();
    }

    @Test
    public void readFileWithBuffer() throws Exception {
        String fileName = "word.txt";
        BufferedInputStream fileInputStream = new BufferedInputStream(new FileInputStream(fileName));
        long start = System.currentTimeMillis();
        int b = 0;
        byte[] byteSize = new byte[8 * 1024];
        while ((b = fileInputStream.read(byteSize)) != -1) {
        }
        long end = System.currentTimeMillis();
        System.out.println((end - start) + "ms");
        fileInputStream.close();
    }

    @Test
    public void testStr() {
        System.out.println(strToHexStr("27309810"));
        System.out.println(Long.toHexString(Long.parseLong("27309810")));
        System.out.println(strToHexStr("76496609"));
    }

    public String strToHexStr(String str) {
        String hexStr = Long.toHexString(Long.parseLong(str));
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < hexStr.length() / 2; i++) {
            res.insert(0, hexStr.substring(i * 2, i * 2 + 2));
        }
        return res.toString().toUpperCase();
    }
}
