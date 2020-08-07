package com.qianma.concurrencyjava.concurrency.读写分离;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/14
 */
public class ReaderWriterClient {
    public static void main(String[] args) throws InterruptedException {
        final ShareData data = new ShareData(10);
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        new ReaderWorker(data).start();
        Thread.sleep(1000);
        new WriteWorker(data,"qwertyuiop").start();
        new WriteWorker(data,"QWERTYUIOP").start();


    }
}
