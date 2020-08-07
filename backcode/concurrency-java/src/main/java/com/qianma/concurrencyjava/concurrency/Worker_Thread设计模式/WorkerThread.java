package com.qianma.concurrencyjava.concurrency.Worker_Thread设计模式;

import java.util.Random;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/20
 */
public class WorkerThread extends Thread {
    private final Channel channel;
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    public WorkerThread(String s, Channel channel) {
        super(s);
        this.channel = channel;
    }

    @Override
    public void run() {
        while (true){
            try {
                channel.take().execute();
                Thread.sleep(RANDOM.nextInt(1_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
