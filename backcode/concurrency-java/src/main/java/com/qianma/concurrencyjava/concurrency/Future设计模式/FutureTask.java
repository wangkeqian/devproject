package com.qianma.concurrencyjava.concurrency.Future设计模式;

public interface FutureTask<T> {
    T call() throws InterruptedException;
}
