package com.qianma.concurrencyjava.concurrency.观察者模式;

import java.util.Arrays;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/11
 */
public class ThreadLifeCycleClient {
    public static void main(String[] args) {
        new ThreadLifeCycleObserver().batchQuery(Arrays.asList("T1","T2"));
    }
}
