package com.qianma.concurrencyjava.concurrency.chepter3;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/23
 */
public class CreateThread2 {
    private static int COUNT = 0;

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            Thread innerThread = new Thread(()->{
                try {
                    while (true){
                        Thread.sleep(5_000);
                        System.out.println("innerThread do some thing for health check");
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
            innerThread.setDaemon(true);
            innerThread.start();
            try {
                Thread.sleep(10_000);
                System.out.println("t thread finish done");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t.start();
        try {
            Thread.sleep(30_000);
            System.out.println("main_thread finish done");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }


}
