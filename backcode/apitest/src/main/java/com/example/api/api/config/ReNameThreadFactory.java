package com.example.api.api.config;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 在ExecutorService里对Thread的命名规则
 *
 * @author wangkq
 * @date 2020/10/9
 */
public class ReNameThreadFactory implements ThreadFactory {
    private volatile AtomicInteger count = new AtomicInteger(0);
    @Override
    public Thread newThread(Runnable r) {
        Thread newThread = new Thread(r);
        newThread.setName("CrawlerThread-"+count.incrementAndGet());
        return newThread;
    }
}
