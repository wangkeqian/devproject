package com.qianma.concurrencyjava.concurrency.Future设计模式2删;

/**
 * 设计师 提供制作方法
 *
 * @author wangkq
 * @date 2020/6/14
 */
public interface FutureTask<T> {
    T call() throws InterruptedException;
}
