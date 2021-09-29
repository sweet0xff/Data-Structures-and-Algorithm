package com.github.sweet.concurrency.thread.stop;

import java.util.concurrent.TimeUnit;

/**
 * @author sweet
 * @description 在run中try catch，方法签名中抛出
 * @date 2021/9/29 14:51
 */
public class RightWayStopThread implements Runnable {
    @Override
    public void run() {
        // && !Thread.currentThread().isInterrupted() 增加该判断无用, sleep会清除中断标记位
        while (true) {
            try {
                System.out.println("执行方法调用 heHe()");
                heHe();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                System.out.println("save log");
                e.printStackTrace();
            }
        }
    }

    private void heHe() throws InterruptedException {
        Thread.sleep(1000);
    }

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThread());
        thread.start();
        Thread.sleep(500);
        thread.interrupt();
    }
}
