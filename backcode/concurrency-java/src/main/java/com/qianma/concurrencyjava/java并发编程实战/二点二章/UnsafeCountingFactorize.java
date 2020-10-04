package com.qianma.concurrencyjava.java并发编程实战.二点二章;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/9/29
 */
public class UnsafeCountingFactorize {
    private static  AtomicInteger count = new AtomicInteger(0) ;
    public static void service(){
        count.getAndIncrement();
        System.out.println("Thread-"+Thread.currentThread().getName()+"- count = "+count);
    }

    public static void main(String[] args) {
        IntStream.range(0,10_0000).forEach(e ->{
            new Thread(() -> {
                service();
            },"No."+(e+1)).start();
        });

    }
}
