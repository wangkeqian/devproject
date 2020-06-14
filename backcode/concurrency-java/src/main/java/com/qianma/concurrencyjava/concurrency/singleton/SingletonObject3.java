package com.qianma.concurrencyjava.concurrency.singleton;

import java.util.Optional;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/8
 */
public class SingletonObject3 {
    private static volatile SingletonObject3 instance;

    public SingletonObject3() {
    }
    public static SingletonObject3 getInstance(){
        if (instance==null){
            synchronized (SingletonObject3.class){
                if (instance==null) {
                    return new SingletonObject3();
                }
            }
        }
        return SingletonObject3.instance;
    }
}
