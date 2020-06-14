package com.qianma.concurrencyjava.concurrency.chepter5;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/25
 */
public class InterruptThread {

    private static class WorkThread extends Thread{
        @Override
        public void run() {
            while (true){

                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

     public static void main(String[] args) {
        WorkThread workThread = new WorkThread();
        workThread.start();

        try {
            Thread.sleep(5_000);
            System.out.println(workThread.isInterrupted());
            workThread.interrupt();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
