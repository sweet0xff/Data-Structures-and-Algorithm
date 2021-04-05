package com.github.sweet.proxy;

/**
 * @description
 * @date 2021/4/4 21:20
 */
public class TimeUsageAspect implements Aspect{

    private long start;

    @Override
    public void before() {
        this.start = System.currentTimeMillis();
    }

    @Override
    public void atfer() {
        long usageTime = System.currentTimeMillis() - this.start;
        System.out.format("time usage %dms\n", usageTime);
    }
}
