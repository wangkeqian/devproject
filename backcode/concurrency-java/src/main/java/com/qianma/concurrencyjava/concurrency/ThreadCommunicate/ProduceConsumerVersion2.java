package com.qianma.concurrencyjava.concurrency.ThreadCommunicate;

import java.util.stream.Stream;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/30
 */
public class ProduceConsumerVersion2 {
    private Object LOCK = new Object();
    private volatile boolean isProducing = true;
    //resource1
    private static int resource1 = 1;

    //produce
    private void produce(String name){
        synchronized (LOCK){
            while (!isProducing){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (resource1%1000==0){
                isProducing = false;
                System.out.println(name+"=>"+resource1);
                LOCK.notify();
            }else {
                while (resource1%1000!=0){
                    resource1++;
//                        System.out.println("resource1:"+resource1);
                }
            }
        }
    }
    //consumer
    public void consumer(String name){
        synchronized (LOCK){
            while (isProducing){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(name+"=>"+ resource1);
            isProducing = true;
            resource1++;
            LOCK.notifyAll();
        }
    }

    public static void main(String[] args) {
        ProduceConsumerVersion2 pc = new ProduceConsumerVersion2();
        Stream.of("P1","P2","P3","P4").forEach(e ->{
            new Thread(()->{
                while (true){
                    pc.produce(e);
                }
            },e).start();
        });
        Stream.of("C1","C2","C3","C4").forEach(e->{
            new Thread(()->{
                while (true){
                    pc.consumer(e);
                }
            },e).start();
        });
    }
}
