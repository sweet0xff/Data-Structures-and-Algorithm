package com.github.sweet.concurrency.threadpool;

import java.util.LinkedList;

/**
 * @author sweet
 * @description
 * @date 2021/10/14 10:06
 */
public class SimpleThreadPool {
    private static final int DEFAULT_SIZE = 10;
    private int size;
    private static final LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    public SimpleThreadPool() {
        this(DEFAULT_SIZE);
    }

    public SimpleThreadPool(int size) {
        this.size = size;
        init();
    }

    private void init() {
    }

    private enum TaskState {
        FREE, RUNNING, BLOCKED, DEAD
    }

    private static class WorkTask extends Thread {
        private volatile TaskState taskState = TaskState.FREE;

        public WorkTask(ThreadGroup group, String name) {
            super(group, name);
        }

        public TaskState getTaskState() {
            return this.taskState;
        }

        public void run() {
            while (this.taskState != TaskState.DEAD) {
                synchronized (TASK_QUEUE) {

                }
            }
            return;
        }

        public void close() {
            this.taskState = TaskState.DEAD;
        }
    }

}
