package com.qianma.community;

import com.qianma.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/1
 */

public class QuestionTestController {

    public static void main(String[] args) {
        Thread[] threads = new Thread[1000];
        for (int i = 0; i < 1000; i++) {
            threads[i] = new RandomThread("RandomThread:" + i);
        }
        for(Thread thread : threads) {
            thread.start();
        }
    }

}
class RandomThread extends Thread {

    QuestionService questionService  = new QuestionService();

    public RandomThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        questionService.setCount("268516b4-d5de-4708-9b57-1c7ce4e7dc53","view");
    }
}