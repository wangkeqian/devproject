package com.qianma.concurrencyjava.concurrency.读写分离;

/**
 * 读写锁
 *
 * @author wangkq
 * @date 2020/6/14
 */
public class ReadWriteLock {
    //当前有几个线程在进行读的操作
    private int readingReaders = 0;
    //当前有几个线程想读，但还在等待队列中
    private int waitingReaders = 0;
    //正在写的线程
    private int writingWriters = 0;
    //当前有多少个写线程在等待
    private int waitingWriters = 0;

    private boolean preferWrite;

    public ReadWriteLock() {
        this(true);
    }

    public ReadWriteLock(boolean preferWrite) {
        this.preferWrite = preferWrite;
    }

    //读锁
    public synchronized void readLock() throws InterruptedException {
        waitingReaders++;
        try{
            while (writingWriters>0 || (preferWrite && waitingWriters >0)){
                this.wait();
            }
            readingReaders++;
        }finally {
            waitingReaders--;
        }
    }
    //读放弃锁
    public synchronized void readUnLock(){
             this.readingReaders--;
             this.notifyAll();
    }

    //写锁
    public synchronized void writeLock() throws InterruptedException {
        waitingWriters++;
        try {
            while (readingReaders>0 || writingWriters>0){
                this.wait();
            }
            writingWriters++;
        }finally {
            waitingWriters--;
        }
    }
    //解锁
    public synchronized void writeUnlock(){
        writingWriters--;
        this.notifyAll();
    }


}
