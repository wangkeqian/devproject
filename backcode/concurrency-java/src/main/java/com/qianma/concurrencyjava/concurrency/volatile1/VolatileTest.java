package com.qianma.concurrencyjava.concurrency.volatile1;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/9
 */
public class VolatileTest {
    private static volatile int INIT_VALUE = 0;
    private static volatile int MAX_VALUE = 50;

    public static void main(String[] args) {
        new Thread(()->{
            int innerValue = INIT_VALUE;
            while (innerValue<MAX_VALUE){
                if (innerValue != INIT_VALUE){
                    System.out.println("INIT_VALUE已经被更新了 ->"+INIT_VALUE);
                    innerValue = INIT_VALUE;
                }
            }
        },"READER").start();

        new Thread(()->{
           int innerValue = INIT_VALUE;
           while (innerValue<MAX_VALUE){
               try {
                   Thread.sleep(500);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println("更新INIT_VALUE ->" + ++INIT_VALUE);
               innerValue = INIT_VALUE;
           }
        },"UPDATER").start();
    }
}
