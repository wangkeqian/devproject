package com.qianma.concurrencyjava.concurrency.Future设计模式2删;

import java.util.Arrays;
import java.util.Collections;
import java.util.function.Consumer;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/14
 */
public class AysnFutureClient {
    public static void main(String[] args) throws InterruptedException {
        FutureService<Object> futureService = new FutureService<>();
        Consumer<String> consumer = o -> {

        };
        Future<Object> submit = futureService.submit(() -> {
            System.out.println("开始执行任务");
            Thread.sleep(5_000);
            System.out.println("任务执行结束");
            return "hello world!";
        },e -> System.out.println(e+" 你好"));
        System.out.println("===============");
        System.out.println("do other thing");
        System.out.println("------------");
    }
}
