package com.qianma.concurrencyjava.concurrency.chepter8;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/12
 */
public class Gate {
    private int counter = 0;
    private String name = "Nobody";
    private String address = "NoWhere";
    private Object object = new Object();

    public void pass(String name,String address){
        synchronized (object) {
            this.counter++;
            this.name = name;
            this.address = address;
            verify();
        }
    }
    public  void verify(){
        if (this.name.charAt(0) != this.address.charAt(0)){
            System.out.println("-------------ERROR------------"+toString());
        }
    }

    @Override
    public String toString() {
        return "No."+counter+":"+name+","+address;
    }
}
