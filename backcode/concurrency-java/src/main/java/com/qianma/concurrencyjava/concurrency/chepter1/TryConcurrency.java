package com.qianma.concurrencyjava.concurrency.chepter1;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/23
 */
public class TryConcurrency {

    public static void main(String[] args) {
        loadDataFromDataBase();
        writeDateToFile();
    }
    private static void loadDataFromDataBase(){
        System.out.println("begin load data from db");
        try {
            Thread.sleep(1000 * 10L);
            System.out.println("read data done and start handle it");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("The data handle finish and successfully ");

    }

    private static void writeDateToFile(){
        System.out.println("begin write data to file");
        try {
            Thread.sleep(1000 * 10L);
            System.out.println("read data done and start handle it");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
