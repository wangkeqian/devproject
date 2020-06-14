package com.qianma.concurrencyjava.concurrency.CollectMachineData;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/24
 */
public class CollectApi {
    public static void main(String[] args) throws InterruptedException {
        Thread m1 = new Thread(new CollectDataRunnable("M1",5_000));
        Thread m2 = new Thread(new CollectDataRunnable("M2",10_000));
        Thread m3 = new Thread(new CollectDataRunnable("M3",15_000));
        m1.start();
        m2.start();
        m3.start();

        m1.join();


        System.out.println("begin save result to database");
    }
}
