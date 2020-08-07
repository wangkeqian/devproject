package com.qianma.concurrencyjava.concurrency.Worker_Thread设计模式;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/20
 */
public class Channel {
    private final Request[] request;
    private final WorkerThread[] workerThread;
    private final int MAX_REQUEST = 100;
    private int head;
    private int tail;
    private volatile int count;

    public Channel(int worker) {
        this.request = new Request[MAX_REQUEST];
        this.workerThread = new WorkerThread[worker];
        this.head = 0;
        this.tail = 0;
        this.count = 0;//请求队列size
        init();
    }
    private void  init(){
        IntStream.rangeClosed(0,workerThread.length-1).forEach(i->{
            workerThread[i] = new WorkerThread("worker"+i,this);
        });
    }
    public void startWorker(){
        Arrays.stream(workerThread).forEach(Thread::start);
    }
    public synchronized void put(Request request){
        while (count>=this.request.length){
            try {
                this.wait();
            }catch (InterruptedException e){

            }
        }
        this.request[tail] = request;
        tail = (tail+1)%this.request.length;
        count++;
        notifyAll();
    }

    public synchronized Request take(){
        while (count<=0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Request request = this.request[head];
        this.head = (this.head+1)%this.request.length;
        this.count--;
        notifyAll();
        return request;
    }
}
