package com.github.sweet.concurrency.thread.waitandnotify;

/**
 * @author sweet
 * @description
 * @date 2021/9/29 20:30
 */
public class WaitAndNotifyAll implements Runnable{
    private static final Object object = new Object();
    public static void main(String[] args) throws InterruptedException {
        WaitAndNotifyAll waitAndNotifyAll = new WaitAndNotifyAll();
        Thread thread1 = new Thread(waitAndNotifyAll);
        Thread thread2 = new Thread(waitAndNotifyAll);

        Thread thread3 = new Thread(() -> {
            synchronized (object) {
                System.out.println(Thread.currentThread().getName() + " notify");
                object.notifyAll();
//                object.notify();
            }
        });
        thread1.start();
        thread2.start();

//        Thread.sleep(1000);
        thread3.start();
    }

    @Override
    public void run() {
        synchronized (object) {
            try {
                System.out.println(Thread.currentThread().getName() + " 开始释放锁");
                object.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " 继续执行");
        }
    }
}
