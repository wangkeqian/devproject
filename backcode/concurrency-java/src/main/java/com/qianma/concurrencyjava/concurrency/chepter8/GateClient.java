package com.qianma.concurrencyjava.concurrency.chepter8;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/12
 */
public class GateClient {
    public static void main(String[] args) {
        Gate gate = new Gate();
        User bj = new User("BaoBao", "Beijing", gate);
        User sh = new User("ShangLao", "Shanghai", gate);
        User gz = new User("Guanglao", "Guangzhou", gate);

        bj.start();
        sh.start();
        gz.start();

    }
}
