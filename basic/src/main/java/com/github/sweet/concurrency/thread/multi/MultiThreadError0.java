package com.github.sweet.concurrency.thread.multi;

/**
 * @author sweet
 * @description
 * @date 2021/9/30 15:58
 */
public class MultiThreadError0 implements Runnable {
    int count;

    public static void main(String[] args) {
        MultiThreadError0 multiThreadError = new MultiThreadError0();
        Thread thread0 = new Thread(multiThreadError);
        Thread thread1 = new Thread(multiThreadError);
        thread0.start();
        thread1.start();
        try {
            thread0.join();
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(multiThreadError.count);

    }

    @Override
    public void run() {
//        while (count<10000) {
//            count++;
//        }
        for (int i = 0; i < 10000; i++) {
            count++;
        }
    }
}
