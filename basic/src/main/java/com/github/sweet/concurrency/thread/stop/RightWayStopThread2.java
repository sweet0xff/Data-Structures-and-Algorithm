package com.github.sweet.concurrency.thread.stop;

/**
 * @author sweet
 * @description 最佳实践，恢复中断, 两阶段终止模式
 * @date 2021/9/28 16:05
 */
public class RightWayStopThread2 implements Runnable{

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new RightWayStopThread2());
        thread.start();
        Thread.sleep(1000);
        thread.interrupt();
    }

    @Override
    public void run() {
        while (true) {
            if (Thread.currentThread().isInterrupted()) {
                System.out.println("thread被中断, 记录日志 log 等操作");
                break;
            }
            System.out.println("go");
            heHe();
        }
    }

    private void heHe() {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            //如果不恢复中断，sleep被打断后的interruptedException会清除中断标志位，导致上面的while不会停止
            Thread.currentThread().interrupt();
            e.printStackTrace();
        }
    }
}
