package com.qianma.concurrencyjava.concurrency.utils;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/27
 */
public class Test {


    public static void main(String[] args) {
        long startMils = System.currentTimeMillis();
        ThreadUtils utils = new ThreadUtils();
        utils.execute(()->{
            try {
                Thread.sleep(5_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
/*            while (true){
                try {
                    Thread.sleep(5_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("running task ...");
            }*/
        });
        utils.shutdown(10_000);
        long endMils = System.currentTimeMillis();
        System.out.println(endMils-startMils);
    }
}
