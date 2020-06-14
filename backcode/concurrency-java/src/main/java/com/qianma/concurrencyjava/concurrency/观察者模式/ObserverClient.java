package com.qianma.concurrencyjava.concurrency.观察者模式;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/11
 */
public class ObserverClient {

    public static void main(String[] args) {
        final Subject subject = new Subject();
        new BinaryObserver(subject);
        new OctalObserver(subject);
        System.out.println("---------------------");
        subject.setState(10);
        System.out.println("++++++++++++++++++++++");
        subject.setState(10);
        System.out.println("=========================");
        subject.setState(20);

    }
}
