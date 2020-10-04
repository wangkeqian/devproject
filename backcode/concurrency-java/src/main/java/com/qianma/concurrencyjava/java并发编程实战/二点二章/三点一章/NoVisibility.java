package com.qianma.concurrencyjava.java并发编程实战.二点二章.三点一章;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/9/29
 */
public class NoVisibility {
    private static boolean ready ;
    private static int number;
//    private static void readyThread(){
//        new Thread(()->{
//            while (!ready){
//                Thread.yield();
//                System.out.println("number = "+number);
//            }
//        }).start();
//    }
    private static class ReadyThread extends Thread{
        
        @Override
        public void run() {
            while (!ready){
                Thread.yield();
                System.out.println("number = "+number);
            }
        }
}

    public static void main(String[] args) throws InterruptedException {
        new ReadyThread().start();
        number = 40;
        ready = true;
    }

}
