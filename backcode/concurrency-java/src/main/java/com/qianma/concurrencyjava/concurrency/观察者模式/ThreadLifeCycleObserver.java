package com.qianma.concurrencyjava.concurrency.观察者模式;

import java.util.List;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/11
 */
public class ThreadLifeCycleObserver implements LifeCycleListener {

    public final Object LOCK = new Object();

    public void batchQuery(List<String> ids ){
        if (ids == null || ids.isEmpty()) return;
        ids.stream().forEach(id -> new Thread(new ObservableRunnable(this) {
            @Override
            public void run() {
                try {
                    notifyObserver(new RunnableEvent(RunnableState.RUNNING,Thread.currentThread(),null));
                    System.out.println("query for id is running id = "+id);
                    Thread.sleep(5_000);
                    int a = 1/0;
                    notifyObserver(new RunnableEvent(RunnableState.DONE,Thread.currentThread(),null));
                }catch (Exception e){
                    notifyObserver(new RunnableEvent(RunnableState.ERROR,Thread.currentThread(),e));
                }
            }}
        ,id).start());

    }

    //因为可能多线程调用，加锁
    @Override
    public void onEvent(ObservableRunnable.RunnableEvent event) {
        synchronized (LOCK){
            System.out.println("the runnable ["+event.getThread().getName()+"] date changed and  state is "+event.getState());
            if (event.getCause() != null){
                System.out.println("the runnable ["+event.getThread().getName()+"] process failed. ");
                event.getCause().printStackTrace();
            }
        }
    }
}
