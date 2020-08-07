package com.qianma.concurrencyjava.concurrency.读写分离;

import java.util.Random;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/14
 */
public class WriteWorker extends Thread {
    private final  ShareData data;
    private final String filler;
    private volatile int index = 0;
    private Random random = new Random();


    public WriteWorker(ShareData data, String filler) {
        this.data = data;
        this.filler = filler;
    }

    @Override
    public void run() {
        try {
            while (true){
                char c = nextChar();
                data.write(c);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    private char nextChar() {
        if (index >= filler.length()){
            index = 0;
        }
        char c = filler.charAt(index);
        index ++ ;
        return c;
    }
}
