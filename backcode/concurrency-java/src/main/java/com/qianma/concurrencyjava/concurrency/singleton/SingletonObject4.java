package com.qianma.concurrencyjava.concurrency.singleton;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/8
 */
public class SingletonObject4 {

    public SingletonObject4() {
    }
    private static class InstanceHolder{
        private static final SingletonObject4 instance = new SingletonObject4();
    }
    public SingletonObject4 getInstance(){
        return InstanceHolder.instance;
    }
}
