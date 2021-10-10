package com.github.sweet.concurrency.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.*;

/**
 * @author sweet
 * @description 如果不加 sync 会出现相同的时间，但是加锁效率比较低，可用localThread重构
 * @date 2021/10/8 16:53
 */
public class ThreadPoolDemo {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(8, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int j = i;
            threadPool.execute(() -> {
                String date =new ThreadPoolDemo().date(j);
                System.out.println(date);
            });
        }
        threadPool.shutdown();
    }

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        String d = "";
        synchronized (ThreadPoolDemo.class) {
            d = simpleDateFormat.format(date);
        }
        return d;
    }
}
