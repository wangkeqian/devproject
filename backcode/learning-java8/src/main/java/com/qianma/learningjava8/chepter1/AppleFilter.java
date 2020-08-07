package com.qianma.learningjava8.chepter1;

import lombok.Data;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.function.*;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/24
 */
@Data
public class AppleFilter {

    private String color;
    private int weight;

    @FunctionalInterface
    private interface FilterApple{
        boolean filter(Apple apple);
    }
    public static List<Apple> getAppleBycond(List<Apple> apples, BiPredicate<String,Integer> filterApple){
        ArrayList<Apple> list = new ArrayList<>();
        for (Apple apple : apples){
            if (filterApple.test(apple.getColor(),apple.getWeight())){
                list.add(apple);
            }
        }
        return list;
    }
    public static void getAppleBycond(List<Apple> apples, BiConsumer<Apple,String> consumer){
        apples.forEach(e -> consumer.accept(e,"hi"));
    }

    public static int getInt(Function<String,Integer> function,String value){
        return function.apply(value);
    }

    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,11,23,5,6,3,48,8,9,23);
        Integer integer = list.stream().filter(i -> i > 10).findAny().get();
        System.out.println(integer);
    }
}
