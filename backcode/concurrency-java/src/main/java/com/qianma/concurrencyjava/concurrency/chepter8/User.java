package com.qianma.concurrencyjava.concurrency.chepter8;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/12
 */
public class User extends Thread{

    private final String myName;
    private final String address;
    private final Gate gate;

    public User(String myName, String address, Gate gate) {
        this.myName = myName;
        this.address = address;
        this.gate = gate;
    }

    @Override
    public void run() {
        System.out.println(myName+"-BEGIN");
        while (true){
            this.gate.pass(myName,address);
        }
    }
}
