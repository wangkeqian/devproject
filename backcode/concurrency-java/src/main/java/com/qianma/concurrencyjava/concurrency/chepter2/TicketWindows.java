package com.qianma.concurrencyjava.concurrency.chepter2;

/**
 * 银行叫号器
 * 假设有四个叫号器，如何实现叫号不冲突
 * @author wangkq
 * @date 2020/5/23
 */
public class TicketWindows extends Thread{
    private static int index  = 0;
    private String concurrentBankName;
    private static int MAXNUM = 50;

    public TicketWindows(String name){
        this.concurrentBankName = name;
    }

    @Override
    public void run() {
        while (index <= MAXNUM){
        System.out.println("柜台："+concurrentBankName+"当前的号码是"+index);
        index ++;
        }
    }
}
