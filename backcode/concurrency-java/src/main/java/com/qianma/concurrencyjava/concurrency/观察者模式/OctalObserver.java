package com.qianma.concurrencyjava.concurrency.观察者模式;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/11
 */
public class OctalObserver extends Observer {

    public OctalObserver(Subject subject) {
        super(subject);
    }

    @Override
    public void update() {
        System.out.println("Octal string:"+Integer.toOctalString(subject.getState()));
    }
}
