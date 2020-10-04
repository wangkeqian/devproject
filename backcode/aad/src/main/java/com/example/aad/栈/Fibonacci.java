package com.example.aad.栈;

import java.util.stream.IntStream;

/**
 * 栈的应用-斐波那契实现
 *
 * @author wangkq
 * @date 2020/8/17
 */
public class Fibonacci {
    public static int fib(int i ){
        if (i < 2)
            return i==0?0:1;
        return fib(i - 2) + fib(i - 1);
    }

    public static void main(String[] args) {
        System.out.println(fib(12));
    }

}
