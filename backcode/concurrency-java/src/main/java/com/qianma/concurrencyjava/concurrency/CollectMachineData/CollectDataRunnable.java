package com.qianma.concurrencyjava.concurrency.CollectMachineData;

import lombok.Data;

/**
 * 采集机器数据Runnable
 *
 * @author wangkq
 * @date 2020/5/24
 */
@Data
public class CollectDataRunnable implements Runnable {

    private String machineName;

    private long spendTime;

    public CollectDataRunnable() {
    }

    public CollectDataRunnable(String machineName, long spendTime) {
        this.machineName = machineName;
        this.spendTime = spendTime;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(spendTime);
            System.out.println(getResult());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public String getResult(){
        return machineName+" finished.";
    }
}
