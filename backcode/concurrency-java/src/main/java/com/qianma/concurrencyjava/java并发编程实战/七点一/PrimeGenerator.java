package com.qianma.concurrencyjava.java并发编程实战.七点一;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/2
 */
public class PrimeGenerator implements Runnable {
    private final List<BigInteger> primes = new ArrayList<>();
    private volatile boolean cancelled;
    @Override
    public void run() {
        BigInteger p = BigInteger.ONE;
        while (!Thread.currentThread().isInterrupted()){
            p = p.nextProbablePrime();
            synchronized (this) {
                primes.add(p);
            }
        }
    }
    public void cancel(){
        System.out.println("cancel方法："+Thread.currentThread().getName());
        Thread.currentThread().interrupt();
    }
    public synchronized List<BigInteger> get(){return new ArrayList<>(primes);}
}
