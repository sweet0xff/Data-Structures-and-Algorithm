package com.github.sweet.concurrency;

import java.util.concurrent.*;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author
 * @description b d 因为有final修饰，编译期间就确定了，和a一样，指向常量池。e运行时才确定， 指向堆
 * d == a
 * e != a
 * g != a
 * @date 2021/10/9 20:44
 */
public class FinalString {
    public static void main(String[] args) {
        new ConcurrentHashMap(10);
        CopyOnWriteArrayList<Object> objects = new CopyOnWriteArrayList<>();
        LinkedBlockingQueue<Object> blockingQueue = new LinkedBlockingQueue<>();

        Executors.newFixedThreadPool(6).submit(() -> {
            System.out.println("x");
        });
        Executors.newCachedThreadPool();
        new ThreadLocal<>();
        Executors.newSingleThreadExecutor();
        new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors() + 1,
                Runtime.getRuntime().availableProcessors() * 2,
                60,
                TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(60),
                r -> {
                    Thread thread = new Thread();
                    thread.setDaemon(true);
                    return thread;
                },
                new ThreadPoolExecutor.CallerRunsPolicy()
        );
        Executors.newScheduledThreadPool(5);
        ArrayBlockingQueue<String> strings = new ArrayBlockingQueue<>(10);
        try {
            new ReentrantLock().lockInterruptibly();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        LongAdder la = new LongAdder();

        new CountDownLatch(5);
        new CyclicBarrier(5);
        new Semaphore(5);
        String a = "xxx2";
        final String b = "xxx";
        String c = "xxx";
        String d = b + "2";
        String e = c + "2";
        System.out.println(d == a);
        System.out.println(e == a);

        final String f = getString();
        String g = f + "2";
        System.out.println(g == a);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(10, 10, 1000, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(10));
        Future future = executor.submit(new FutureDemo());

    }

    private static String getString() {
        return "xxx";
    }
}

class FutureDemo implements Callable {

    @Override
    public Object call() throws Exception {
        return "hello";
    }
}
