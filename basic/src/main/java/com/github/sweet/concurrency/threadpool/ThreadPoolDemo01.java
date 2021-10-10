package com.github.sweet.concurrency.threadpool;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author sweet
 * @description localThread重构
 * @date 2021/10/8 16:53
 */
public class ThreadPoolDemo01 {
    static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(8, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));

    public static void main(String[] args) {
        for (int i = 0; i < 1000; i++) {
            int j = i;
            threadPool.execute(() -> {
                String date = new ThreadPoolDemo01().date(j);
                System.out.println(date);
            });
        }
        threadPool.shutdown();
    }

    public String date(int seconds) {
        Date date = new Date(1000 * seconds);
        SimpleDateFormat simpleDateFormat = ThreadSafeFormat.dateFormatThreadLocal1.get();
        return simpleDateFormat.format(date);
    }
}

class ThreadSafeFormat {
    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal1 =
            ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));

    public static ThreadLocal<SimpleDateFormat> dateFormatThreadLocal2 = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };
}