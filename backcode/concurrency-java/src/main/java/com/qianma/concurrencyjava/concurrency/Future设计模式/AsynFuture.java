package com.qianma.concurrencyjava.concurrency.Future设计模式;

/**
 * 移步
 *
 * @author wangkq
 * @date 2020/6/14
 */
public class AsynFuture<T> implements Future {
    private volatile boolean done = false;//认识是否完成 true 完成 false 未完成

    private T result;
    public void done(T result){
        synchronized (this){
            this.result = result;
            this.done = true;
            this.notifyAll();
        }
    }

    @Override
    public T get() throws InterruptedException {
        synchronized (this){
            while (!done){
                this.wait();
            }
        }
        return result;
    }
}
