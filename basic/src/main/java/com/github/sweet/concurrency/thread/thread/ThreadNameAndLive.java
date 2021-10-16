package com.github.sweet.concurrency.thread.thread;

/**
 * @author sweet
 * @description
 * @date 2021/9/28 10:37
 */
public class ThreadNameAndLive {
    public static void main(String[] args) {
        MyThread4 thread4 = new MyThread4();
        thread4.setName("xxx");
        thread4.start();
    }
}

class MyThread4 extends Thread {
    public MyThread4() {
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