package com.github.sweet.io;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;

/**
 * @author sweet
 * @description
 * @date 2021/10/19 09:14
 */
public class BufferedReaderDemo {
    public static void main(String[] args) throws Exception{
        InputStreamReader reader = new InputStreamReader(new FileInputStream("a.txt"), "UTF-8");
        reader.read();
        BufferedReader bufferedReader  = new BufferedReader(new InputStreamReader(new FileInputStream("a.txt"), "UTF-8"));
        bufferedReader.read();
    }
}
