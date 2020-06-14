package com.qianma.concurrencyjava.concurrency.chepter7;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/27
 */
public class Test {
    public static void main(String[] args) {
        int MAXNUM = 500;
        final TicketWindows ticketWindows = new TicketWindows();
        Thread thread1 = new Thread(ticketWindows,"一号窗口");
        Thread thread2 = new Thread(ticketWindows,"二号窗口");
        Thread thread3 = new Thread(ticketWindows,"三号窗口");
        /*thread1.start();
        thread2.start();
        thread3.start();*/
        Thread t = new Thread(()->{
            try {
                Thread.sleep(5_000);
                int a  = 10 / 0;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.setUncaughtExceptionHandler((thread,e)->{
            System.out.println("["+Thread.currentThread()+"]"+e);
        });
        t.start();
        try {
            Thread.sleep(10_000);
            System.out.println("The App will be death");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
