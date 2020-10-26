package com.example.crawler.api;

import com.example.crawler.model.GoodsInfo;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/7
 */
public class ThreadTest {
    public static void main(String[] args) {
        thread();
    }
    public static void thread(){
        new Thread(() ->{
            BigDecimal.ONE.divide(BigDecimal.ZERO);
        }).start();
    }
}
