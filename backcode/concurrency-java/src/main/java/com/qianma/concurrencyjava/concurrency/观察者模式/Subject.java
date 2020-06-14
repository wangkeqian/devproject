package com.qianma.concurrencyjava.concurrency.观察者模式;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/11
 */
public class Subject {

    //该主体的观察者容器
    private List<Observer> observerList = new ArrayList<>();
    //主体状态
    private int state;

    public void setState(int state){
        if (state == this.state){
            return;
        }else {
            this.state = state;
            notifyAllObserver();
        }
    }

    public int getState(){
        return this.state;
    }
    public void attach(Observer observer){
        observerList.add(observer);
    }
    public void notifyAllObserver(){
        observerList.forEach(Observer::update);
    }
}
