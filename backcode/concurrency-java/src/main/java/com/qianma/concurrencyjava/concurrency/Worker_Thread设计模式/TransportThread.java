package com.qianma.concurrencyjava.concurrency.Worker_Thread设计模式;

import sun.jvm.hotspot.debugger.ThreadAccess;

import java.util.Random;

/**
 * 上游 往传送带发送request
 *
 * @author wangkq
 * @date 2020/6/20
 */
public class TransportThread extends Thread{
    private final Channel channel;
    private static final Random RANDOM = new Random(System.currentTimeMillis());
    public TransportThread(String name, Channel channel) {
        super(name);
        this.channel = channel;
    }

    @Override
    public void run() {
        int index = 0;
        while (true){
            try {
                Request request = new Request(Thread.currentThread().getName(),index++);
                this.channel.put(request);
                Thread.sleep(RANDOM.nextInt(1_000));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
