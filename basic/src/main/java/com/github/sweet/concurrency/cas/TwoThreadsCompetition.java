package com.github.sweet.concurrency.cas;

/**
 * @author
 * @description
 * @date 2021/10/11 17:01
 */
public class TwoThreadsCompetition implements Runnable{
    private volatile int value;

    public synchronized int compareAndSet(int exceptValue, int newValue) {
        int oldValue = value;
        if (oldValue == exceptValue) {
            value = newValue;
        }
        return value;
    }
    public static void main(String[] args) throws InterruptedException {
        TwoThreadsCompetition r = new TwoThreadsCompetition();
        r.value = 0;
        Thread t1 = new Thread(r,"Thread 1");
        Thread t2 = new Thread(r,"Thread 2");
        t1.start();
        t2.start();
        t1.join();
        t2.join();
        System.out.println(r.value);
    }

    @Override
    public void run() {
        compareAndSet(0, 1);
    }
}
