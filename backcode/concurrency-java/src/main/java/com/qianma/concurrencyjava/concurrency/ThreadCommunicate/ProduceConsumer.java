package com.qianma.concurrencyjava.concurrency.ThreadCommunicate;

import java.util.stream.Stream;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/30
 */
public class ProduceConsumer {
    private Object LOCK = new Object();
    private boolean isProducing = true;
    //resource1
    private static int resource1 = 1;

    //produce
    private void produce(String name){
        synchronized (LOCK){
            if (isProducing){
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
            }else {
//                System.out.println("会过这里吗？");
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    //consumer
    public void consumer(String name){
        synchronized (LOCK){
            if (isProducing){
                try {
                    LOCK.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }else {
                System.out.println(name+"=>"+ resource1);
                isProducing = true;
                resource1++;
                LOCK.notify();
            }
        }
    }

    public static void main(String[] args) {
        ProduceConsumer pc = new ProduceConsumer();
        Stream.of("P1","P2").forEach(e ->{
            new Thread(()->{
                while (true){
                    pc.produce(e);
                }
            },e).start();
        });
        Stream.of("C1","C2").forEach(e->{
            new Thread(()->{
                while (true){
                    pc.consumer(e);
                }
            },e).start();
        });
    }
}
