package com.qianma.concurrencyjava.concurrency.chepter3;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/23
 */
public class CreateThread {
    public static void main(String[] args) {
        Thread thread = new Thread( ()->{
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {

            }
        });
        thread.start();
        ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
        Thread[] thread1 = new Thread[threadGroup.activeCount()];
        threadGroup.enumerate(thread1);
        Arrays.asList(thread1).forEach(System.out::println);
    }
}
