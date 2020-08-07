package com.qianma.concurrencyjava.concurrency.Worker_Thread设计模式;

import lombok.Data;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/20
 */
public class Request {
    private String name;
    private int number;

    public Request(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public void execute(){
        System.out.println(Thread.currentThread().getName()+" : Execute : "+this);
    }
    @Override
    public String toString() {
        return "Request ==> No."+number+" Name:"+name;
    }
}
