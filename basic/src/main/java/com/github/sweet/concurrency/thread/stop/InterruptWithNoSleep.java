package com.github.sweet.concurrency.thread.stop;

/**
 * @author
 * @description 该情况适用于没有sleep或者wait的情况，
 *              发出interrupt指令，线程会不会中断取决于线程自己
 * @date 2021/9/28 14:34
 */
public class InterruptWithNoSleep implements Runnable {

    @Override
    public void run() {
        //如果不判断 isInterrupted，该线程会继续执行到结束
        //如果加了，收到中断指令就会停止
        while (!Thread.currentThread().isInterrupted() && true) {
            System.out.println(Thread.currentThread().getName());
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptWithNoSleep());
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }
}
