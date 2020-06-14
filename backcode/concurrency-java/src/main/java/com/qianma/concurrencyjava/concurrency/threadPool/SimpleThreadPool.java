package com.qianma.concurrencyjava.concurrency.threadPool;

import javafx.beans.binding.When;
import org.apache.tomcat.util.threads.TaskQueue;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;
import java.util.stream.IntStream;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/5
 */
public class SimpleThreadPool {
    private final int poolSize;
    private final static int DEFAULT_SIZE = 10;
    private static int seq = 0;
    private ThreadGroup group = new ThreadGroup("thread-pool");
    private static final String THREAD_PREFIX = "SIMPLE_THREAD_POOL-";
    //线程队列
    private List<WorkThread> THREAD_QUEUE = new ArrayList<>();
    //任务队列
    private static final LinkedList<Runnable> TASK_QUEUE = new LinkedList<>();

    private enum TASK_STATUS{
        FREE,RUNNING,BLOCK,DEAD
    }
    public SimpleThreadPool(){
        this(DEFAULT_SIZE);
    }
    public SimpleThreadPool(int poolSize) {
        this.poolSize = poolSize;
        init();
    }
    public void init(){
        IntStream.range(0,poolSize).forEach(e->createWorkThread());
    }
    public void createWorkThread(){
        WorkThread workThread = new WorkThread(group, THREAD_PREFIX+(seq++));
        workThread.start();
        THREAD_QUEUE.add(workThread);
    }
    public void submit(Runnable tasks){
        synchronized (TASK_QUEUE){
            TASK_QUEUE.add(tasks);
            TASK_QUEUE.notifyAll();
        }
    }
    public void shutdown(){
        System.out.println("线程池还有"+THREAD_QUEUE.size());
        while (!TASK_QUEUE.isEmpty()){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        final int[] initVal = {THREAD_QUEUE.size()};
        while (initVal[0] >0){
            THREAD_QUEUE.forEach(t->{
                if (t.getTaskStatus()==TASK_STATUS.BLOCK){
                    t.interrupt();
                    t.close();
                    initVal[0]--;
                }else {
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        System.out.println("任务队列有"+TASK_QUEUE.size()+"个,线程队列有"+THREAD_QUEUE.size()+"个,即将退出程序。。");

    }
    private static class WorkThread extends Thread{

        private TASK_STATUS task_status;

        public WorkThread(ThreadGroup group,String name){
            super(group, name);
        }

        public TASK_STATUS getTaskStatus(){
            return task_status;
        }

        public void close(){
            task_status = TASK_STATUS.DEAD;
        }

        @Override
        public void run() {
            OUTER:
            while (task_status != TASK_STATUS.DEAD){
                Runnable firstTask;
                synchronized (TASK_QUEUE){
                    while (TASK_QUEUE.isEmpty()){
                        try {
                            task_status = TASK_STATUS.BLOCK;
                            TASK_QUEUE.wait();
                        } catch (InterruptedException e) {
                            break OUTER;
                        }
                    }
                    firstTask = TASK_QUEUE.removeFirst();
                }
                task_status = TASK_STATUS.RUNNING;
                firstTask.run();
                task_status = TASK_STATUS.FREE;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        SimpleThreadPool simpleThreadPool = new SimpleThreadPool();
        simpleThreadPool.createWorkThread();
        IntStream.range(0,40).forEach(i ->{
            simpleThreadPool.submit(()->{
                System.out.println("第"+i+"任务正在被"+Thread.currentThread().getName()+"执行，正在开始");
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("第"+i+"任务已经被"+Thread.currentThread().getName()+"执行，已经结束");
            });
        });
        Thread.sleep(20_000);
        simpleThreadPool.shutdown();
    }
}
