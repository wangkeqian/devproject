package com.qianma.concurrencyjava.concurrency.ActiveObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/6/20
 */
public class Servant implements ActiveObject{

    @Override
    public Result makeString(int count, char fillChar) {
        return  null;
    }

    @Override
    public void displayString(String text) {
        try {
            System.out.println("display : "+text);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> list = Arrays.asList("1", "2", "3");
        list.forEach(list::remove);
        System.out.println(list);
    }
}
