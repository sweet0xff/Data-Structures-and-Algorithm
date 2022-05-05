package com.github.sweet.concurrency.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author
 * @description task.get() main线程会阻塞, 等待 t0 执行结束
 * @date 2021/10/16 10:44
 */
public class FutureTaskDemo {
    public static void main(String[] args) {
        FutureTask<Integer> task = new FutureTask<>(() -> {
            System.out.println("debug");
            return 100;
        });
        new Thread(task, "t0").start();
        try {
            System.out.println(task.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("main thread is over");
    }
}
