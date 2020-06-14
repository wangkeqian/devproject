package com.qianma.concurrencyjava.concurrency.chepter3;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/23
 */
public class TickerWindows implements Runnable {
    private  int index  = 1;

    private  int MAXNUM = 50;
    @Override
    public synchronized void run() {
        while (index <= MAXNUM){
            System.out.println("柜台："+Thread.currentThread().getName()+"当前的号码是"+index++);
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
