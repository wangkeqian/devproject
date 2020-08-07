package com.qianma.concurrencyjava.concurrency.Future设计模式2删;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/14
 */
public interface Future<T> {
    T get() throws InterruptedException;
}
