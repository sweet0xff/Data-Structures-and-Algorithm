package com.github.sweet.concurrency.thread.thread;

/**
 * @author sweet
 * @description
 * @date 2021/9/28 09:03
 */
public class ThreadRunnableDemo {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        new MyThread().start();
        new Thread(new MyThread()).start();
        new Thread(new MyThread2(), "he he").start();
        new Thread(() -> System.out.println(Thread.currentThread().getName())).start();
        new Thread(new MyThread3(), "xxx").start();
        new Thread(){
            @Override
            public void run() {
                System.out.println("222");
            }
        }.start();
    }
}

class  MyThread extends Thread {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ", thread run");
    }
}

class MyThread2 implements Runnable {
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + ", thread run");
    }
}

class MyThread3 extends Thread {
    public MyThread3() {
        System.out.println("begin");
        System.out.println("Thread.currentThread().getName(): " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive(): " + Thread.currentThread().isAlive());
        System.out.println("this.getName(): " + this.getName());
        System.out.println("this.isLive(): " + this.isAlive());
        System.out.println("end");
    }
    @Override
    public void run() {
        System.out.println("run begin");
        System.out.println("Thread.currentThread().getName(): " + Thread.currentThread().getName());
        System.out.println("Thread.currentThread().isAlive(): " + Thread.currentThread().isAlive());
        System.out.println("this.getName(): " + this.getName());
        System.out.println("this.isLive(): " + this.isAlive());
        System.out.println("run end");
    }
}