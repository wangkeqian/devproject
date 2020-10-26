package com.qianma.concurrencyjava.JUC;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/18
 */
public class Test1 {
    public static void main(String[] args) {

        Lock lock = new ReentrantLock();
        lock.lock();
        try {
            /*业务代码*/
        } finally {
            lock.unlock();
        }
    }
}
