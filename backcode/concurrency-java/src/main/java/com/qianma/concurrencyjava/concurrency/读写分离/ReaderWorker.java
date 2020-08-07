package com.qianma.concurrencyjava.concurrency.读写分离;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/14
 */
public class ReaderWorker extends Thread{
    private final ShareData data;

    public ReaderWorker(ShareData data) {
        this.data = data;
    }

    @Override
    public void run() {
        try {
            while (true){
                char[] readerBuffer  = data.read();
                System.out.println(Thread.currentThread().getName()+" read ："+String.valueOf(readerBuffer));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
