package com.qianma.concurrencyjava.concurrency.Future设计模式;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/14
 */
public class FutureService {
    public <T> Future<T> submit(final FutureTask<T> task){
        AsynFuture<T> tAsynFuture = new AsynFuture<>();
        new Thread(()->{
            try {
                T result = task.call();
                tAsynFuture.done(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return tAsynFuture;
    }
}
