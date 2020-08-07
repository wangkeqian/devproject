package com.qianma.concurrencyjava.concurrency.读写分离;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * 共享数据
 *
 * @author wangkq
 * @date 2020/6/14
 */
public class ShareData {
    private final char[] buffer ;
    private final ReadWriteLock lock = new ReadWriteLock();


    public ShareData(int size) {
        this.buffer = new char[size];
        for (int i=0;i<buffer.length;i++){
            buffer[i]  = '*';
        }
    }
    public void write(char c) throws InterruptedException {
        try {
            lock.writeLock();
            this.doWrite(c);
        }finally {
            lock.writeUnlock();
        }
    }

    private void doWrite(char c ) {
        for (int i=0;i<buffer.length;i++){
            this.buffer[i] = c ;
        }
        System.out.println("doWrite c="+c+" this.buffer="+String.valueOf(this.buffer));
    }

    public char[] read() throws InterruptedException {
        try {
            lock.readLock();
            return doRead();
        }finally {
            lock.readUnLock();
        }
    }

    private char[] doRead() {
        char[] newBuffer = new char[buffer.length];
        for (int i=0;i<buffer.length;i++){
            newBuffer[i] = buffer[i];
        }
        slowly(50);
        return newBuffer;
    }

    private void slowly(int i) {
        try {
            Thread.sleep(i);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
