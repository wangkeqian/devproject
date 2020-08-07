package com.qianma.concurrencyjava.concurrency.Future设计模式2删;

import java.util.function.Consumer;

/**
 * 掮客
 *
 * @author wangkq
 * @date 2020/6/14
 */
public class FutureService<T> {

    public Future<T> submit(FutureTask<T> task){
        AsynFuture<T> tAsynFuture = new AsynFuture<>();
        new Thread(()->{
            try {
                T result = task.call();
                System.out.println("任务做完了，开始done");
                tAsynFuture.done(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return tAsynFuture;
    }
    public Future<T> submit(final FutureTask<T> task, Consumer<T> consumer){
        AsynFuture<T> tAsynFuture = new AsynFuture<>();
        new Thread(()->{
            try {
                T result = task.call();
                System.out.println("任务做完了，开始done");
                tAsynFuture.done(result);
                consumer.accept(result);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
        return tAsynFuture;
    }
}
