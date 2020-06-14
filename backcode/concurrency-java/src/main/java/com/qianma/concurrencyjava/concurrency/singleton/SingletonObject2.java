package com.qianma.concurrencyjava.concurrency.singleton;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/8
 */
public class SingletonObject2 {

    private static SingletonObject2 install;

    //性能差 线程安全
    public static synchronized   SingletonObject2 getInstance() {
        if (install == null){
            return new SingletonObject2();
        }else {
            return install;
        }
    }
}
