package com.github.sweet.io;

import org.junit.Test;

import java.io.*;

/**
 * @author sweet
 * @description
 * @date 2021/10/19 09:14
 */
public class BufferedReaderDemo {

    @Test
    public void test01() throws Exception{
        InputStreamReader reader = new InputStreamReader(new FileInputStream("a.txt"), "UTF-8");
        reader.read();
        BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt"), "UTF-8"));
        bufferedReader.read();
    }

    @Test
    public void test02() throws IOException {
        BufferedInputStream bufferedInputStream = new BufferedInputStream(new FileInputStream("xx.demo"));
        int content = 0;
        while ((content = bufferedInputStream.read()) != -1) {

        }
    }
}
