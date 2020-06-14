package com.qianma.concurrencyjava.concurrency.utils;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/27
 */
public class ThreadUtils {

    boolean finish = false;
    Thread  main = null;
    public void execute(Runnable task){
        main = new Thread(()->{
            Thread t = new Thread(task);
            /*设为守护线程*/
            t.setDaemon(true);
            t.start();
            try {
                t.join();
                finish = true;
            } catch (InterruptedException e) {
                System.out.println("线程参数被中断 ...");
            }
        });
        main.start();
    }

    public void  shutdown(long mills){
        long currentMills = System.currentTimeMillis();
        while (!finish){
            if (System.currentTimeMillis()-currentMills > mills){
                System.out.println("task is timeout ...");
                main.interrupt();
                break;
            }
            try {
                main.sleep(1);
            } catch (InterruptedException e) {
                System.out.println("执行线程被打断 ... ");
                break;
            }
        }
        finish = false;
    }
}
