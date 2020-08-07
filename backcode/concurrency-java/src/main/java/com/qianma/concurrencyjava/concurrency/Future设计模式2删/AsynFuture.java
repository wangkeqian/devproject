package com.qianma.concurrencyjava.concurrency.Future设计模式2删;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/14
 */
public class AsynFuture<T> implements Future<T>{
    private volatile boolean done = false;
    private T result;

    public void done(T result){
        synchronized (this){
            this.result = result;
            done = true;
            this.notifyAll();
        }
    }
    @Override
    public T get() throws InterruptedException {
        synchronized (this){
            while (!done){
                System.out.println("拿数据，但任务没做完，进入阻塞中");
                //如果任务还没完成
                this.wait();
            }
        }
        //凭什么返回呢，要有人通知你任务完成才返回，谁通知呢。
        return result;
    }
}
