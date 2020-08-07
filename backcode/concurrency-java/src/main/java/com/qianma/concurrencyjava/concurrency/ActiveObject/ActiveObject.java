package com.qianma.concurrencyjava.concurrency.ActiveObject;

/**
 * 接收异步消息的的主动方法
 *
 * @author wangkq
 * @date 2020/6/20
 */
public interface ActiveObject {
    Result makeString(int count, char fillChar);

    void displayString(String text);

}
