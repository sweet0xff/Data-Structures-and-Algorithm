package com.github.sweet.concurrency.thread.stop;

/**
 * @author
 * @description 发出interrupt指令，存在sleep情况, !Thread.currentThread().isInterrupted()是多余的
 * @date 2021/9/28 14:34
 */
public class CantInterruptWithSleep2 implements Runnable {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new CantInterruptWithSleep2());
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }

    @Override
    public void run() {
        //while 中加 !Thread.currentThread().isInterrupted() && 判断是多余， 中断标信号被异常抛出后就清掉了
        while (true && !Thread.currentThread().isInterrupted()) {
            System.out.println(Thread.currentThread().getName());
            try {
                Thread.sleep(20);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
