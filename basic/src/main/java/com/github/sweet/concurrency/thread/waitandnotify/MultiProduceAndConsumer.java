package com.github.sweet.concurrency.thread.waitandnotify;

import java.util.*;

/**
 * @author sweet
 * @description
 * @date 2021/10/13 17:21
 */
public class MultiProduceAndConsumer {
    static LinkedList<Date> controls = new LinkedList<Date>();
    static List<Thread> works = new ArrayList<>(10);
    public static void main(String[] args) {
        Arrays.asList("m1", "m2", "m3", "m4", "m5", "m6", "m7", "m8", "m9", "m10")
                .stream()
                .map(MultiProduceAndConsumer::createT)
                .forEach(t -> {
                    t.start();
                    works.add(t);
                });
        works.stream().forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        Optional.of("All thread finished").ifPresent(System.out::println);
    }

    public static Thread createT(String name) {
        return new Thread(() -> {
            Optional.of("the thread" + Thread.currentThread().getName() + " begin").ifPresent(System.out::println);
            synchronized (controls) {
                while (controls.size() > 5) {
                    try {
                        controls.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                controls.add(new Date());

                Optional.of("the thread" + Thread.currentThread().getName() + " is working").ifPresent(System.out::println);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                synchronized (controls) {
                    Optional.of("the thread" + Thread.currentThread().getName() + "is end").ifPresent(System.out::println);
                    controls.removeFirst();
                    controls.notifyAll();
                }
            }
        }, name);
    }
}
