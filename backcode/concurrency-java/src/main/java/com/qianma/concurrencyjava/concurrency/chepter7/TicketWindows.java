package com.qianma.concurrencyjava.concurrency.chepter7;


import com.qianma.concurrencyjava.concurrency.chepter7.TicketWindows;

/**
 * 银行叫号器
 * 假设有四个叫号器，如何实现叫号不冲突
 * @author wangkq
 * @date 2020/5/23
 */
public class TicketWindows extends Thread{
    private static int index  = 0;
    private static int MAXNUM = 500;

    private Object object = new Object();

    @Override
    public void run() {
        while (true){
            if (ticket()){
                break;
            }
        }
    }

    public synchronized boolean ticket(){
        if (index > MAXNUM) {
             return true;
        }
        try {
            Thread.sleep(5);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("柜台：" + Thread.currentThread().getName() + "当前的号码是" + index++);
        return false;
    }
}
