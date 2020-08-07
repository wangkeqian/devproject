package com.qianma.concurrencyjava.concurrency.Worker_Thread设计模式;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/20
 */
public class WorkerClient {
    public static void main(String[] args) {
        final Channel channel = new Channel(5);
        channel.startWorker();

        new TransportThread("JACK", channel).start();
        new TransportThread("Alex", channel).start();
        new TransportThread("Marc", channel).start();

    }
}
