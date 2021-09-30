package com.github.sweet.concurrency.thread.waitandnotify;

import java.util.Date;
import java.util.LinkedList;

/**
 * @author sweet
 * @description wait 和 notify实现生产者和消费者模型
 * @date 2021/9/30 11:11
 */
public class ProducerAndConsumerModel {
    public static void main(String[] args) throws InterruptedException {
        MsgStorage msgStorage = new MsgStorage(10);
        new Thread(new Producer(msgStorage)).start();
        new Thread(new Consumer(msgStorage)).start();
    }
}

class Consumer implements Runnable{
    MsgStorage msgStorage;
    public Consumer(MsgStorage msgStorage) {
        this.msgStorage = msgStorage;
    }

    @Override
    public void run() {
        while (true) {
            msgStorage.take();
        }
    }
}

class Producer implements Runnable{
    MsgStorage msgStorage;
    public Producer(MsgStorage msgStorage) {
        this.msgStorage = msgStorage;
    }
    @Override
    public void run() {
        while (true) {
            msgStorage.put();
        }
    }
}


class MsgStorage {
    private int maxSize;
    private LinkedList<Date> storage;

    public MsgStorage(int maxSize) {
        this.maxSize = maxSize;
        storage = new LinkedList<>();
    }

    public synchronized void put() {
        while (storage.size() == 10) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        storage.add(new Date());
        System.out.println("消息队列有了 " + storage.size() + " 条消息");
        notify();
    }

    public synchronized void take() {
        while (storage.size() == 0) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("消费了 " + storage.poll() + "消息，现在还剩下" + storage.size());
        notify();
    }
}