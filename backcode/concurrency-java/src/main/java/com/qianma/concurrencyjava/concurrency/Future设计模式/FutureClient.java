package com.qianma.concurrencyjava.concurrency.Future设计模式;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/14
 */
public class FutureClient {
    public static void main(String[] args) throws InterruptedException {
        FutureService futureService = new FutureService();
        Future<String> submit = futureService.submit(() -> {
            Thread.sleep(50_000);
            return "hello world!";
        });
        System.out.println("=================");
        System.out.println("do other thing ....");
        System.out.println("=+==========_+++++");
        System.out.println(submit.get());
    }
}
