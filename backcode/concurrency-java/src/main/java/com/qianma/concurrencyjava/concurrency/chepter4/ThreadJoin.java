package com.qianma.concurrencyjava.concurrency.chepter4;

import java.util.Optional;
import java.util.stream.IntStream;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/24
 */
public class ThreadJoin {
    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(1_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            IntStream.range(1,1000).forEach(i-> System.out.println(Thread.currentThread().getName()+"=>"+i));
        });
        Thread t2 = new Thread(()->{
            IntStream.range(1,1000).forEach(i-> System.out.println(Thread.currentThread().getName()+"=>"+i));
        });
        t1.start();
        t1.join();
        t2.start();
        t2.join();
        Optional.of("All task is finish done").ifPresent(System.out::println);
        IntStream.range(1,1000).forEach(i-> System.out.println(Thread.currentThread().getName()+"=>"+i));

    }
}
