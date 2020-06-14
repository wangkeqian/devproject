package com.qianma.concurrencyjava.concurrency.captureMachine;

import javafx.beans.binding.When;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Optional;

/**
 * 1.控制线程为五个以内
 * 2.线程之间加锁
 *
 * @author wangkq
 * @date 2020/5/31
 */
public class CaptureService {

    private final static int MAX_THREAD = 5;

    private static final LinkedList<Control> CONTROLS = new LinkedList();

    public static void main(String[] args) {
        Arrays.asList("M1","M2","M3","M4","M5","M6","M7","M8","M9","M10").stream().map(CaptureService::createCaptureThread)
                .forEach(t->{
                    t.start();
                });
    }

    public static Thread createCaptureThread(String name){
        return new Thread(()->{
            synchronized (CONTROLS) {
                while (CONTROLS.size() > 5) {
                    try {
                        CONTROLS.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                CONTROLS.addLast(new Control());
            }
            Optional.of("The work ["+Thread.currentThread().getName()+"] is working").ifPresent(System.out::println);
            //TODO
            try {
                Thread.sleep(10_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (CONTROLS){
                Optional.of("The work ["+Thread.currentThread().getName()+"] END work").ifPresent(System.out::println);
                CONTROLS.removeFirst();
                CONTROLS.notifyAll();
            }
        },name);
    }
    private static class Control{}

}

