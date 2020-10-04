package com.qianma.concurrencyjava.java并发编程实战.七点一;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/2
 */
public class primesMain {
    public static void main(String[] args) {
        PrimeGenerator primeGenerator = new PrimeGenerator();
        Thread thread = new Thread(primeGenerator,"子线程");
        thread.start();

        try {
            Thread.sleep(1_000);
        } catch (InterruptedException e) {
            System.out.println("111");
        }finally {
            primeGenerator.cancel();
        }
        primeGenerator.get().forEach(System.out::println);
    }
}
