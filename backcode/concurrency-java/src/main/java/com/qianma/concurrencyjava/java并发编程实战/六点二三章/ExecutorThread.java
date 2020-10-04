package com.qianma.concurrencyjava.java并发编程实战.六点二三章;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/1
 */
public class ExecutorThread {
    private static final int THREADNUM = 10;
    private static final Executor executor = Executors.newFixedThreadPool(THREADNUM);
    public static void main(String[] args) {

        executor.execute(()->{
            System.out.println("jack;");
        });
    }
}
