package com.qianma.concurrencyjava.concurrency.singleton;

/**
 * 单例模式
 *
 * @author wangkq
 * @date 2020/6/8
 */
public class SingletonObject1 {

    /**
     * can't lazy load
     */
    private static final SingletonObject1 install = new SingletonObject1();

    public SingletonObject1() {
    }
    public static SingletonObject1 getInstance(){
        return install;
    }
}
