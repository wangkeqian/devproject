package com.qianma.concurrencyjava.concurrency.chepter3;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/23
 */
public class Bank2 {

    public static void main(String[] args) {
        int MAXNUM = 50;
        final TickerWindows ticketWindows = new TickerWindows();
        final Runnable runnable = ()->{
            int index = 1;
            while (index <= MAXNUM){
                System.out.println("柜台："+Thread.currentThread().getName()+"当前的号码是"+ index++);
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        Thread thread1 = new Thread(runnable,"一号窗口");
        Thread thread2 = new Thread(runnable,"二号窗口");
        Thread thread3 = new Thread(runnable,"三号窗口");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
