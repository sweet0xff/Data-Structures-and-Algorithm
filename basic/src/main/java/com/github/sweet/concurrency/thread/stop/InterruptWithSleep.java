package com.github.sweet.concurrency.thread.stop;

/**
 * @author
 * @description 发出interrupt指令，存在sleep情况,
 * !Thread.currentThread().isInterrupted()判断是多余的
 * @date 2021/9/28 14:34
 */
public class InterruptWithSleep implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptWithSleep());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        try {
            // while里面加!Thread.currentThread().isInterrupted() 判断是多余的判断
            while (true) {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(100);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
