package com.github.sweet.concurrency.thread.stop;

/**
 * @author
 * @description
 * @date 2021/10/13 10:14
 */
public class InterruptDemo implements Runnable{
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new InterruptDemo());
        thread.start();
        Thread.sleep(100);
        //看 interrupt方法注释
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            System.out.println("t0 is running");
            try {
                //响应中断但是 while 不会停止
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
