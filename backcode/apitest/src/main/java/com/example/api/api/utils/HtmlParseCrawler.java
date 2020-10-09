package com.example.api.api.utils;

import com.example.api.api.config.ReNameThreadFactory;
import com.example.api.api.entity.GoodsInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.*;
import java.util.stream.IntStream;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/7
 */

public class HtmlParseCrawler {

    private static final int THREAD_POOL_SIZE = 10;

    public static List<GoodsInfo> parseJDLatch(final String keys){
        CopyOnWriteArrayList<GoodsInfo> result = new CopyOnWriteArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(9);
        ExecutorService executor = Executors.newFixedThreadPool(THREAD_POOL_SIZE,new ReNameThreadFactory());
        IntStream.range(1,10).forEach( num ->{
            executor.execute(() ->{
                try {
                    parsePage(keys, num, result);
                }catch (NullPointerException e){
                    System.out.println(Thread.currentThread().getName()+"-有异常，关闭线程");
                    Thread.currentThread().isInterrupted();
                }
                countDownLatch.countDown();
            });
        });
        try {
            System.out.println("开始等待");
            countDownLatch.await();
            System.out.println("等待结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return result;
    }
    public static void parsePage(String keys,int num ,CopyOnWriteArrayList result){
        System.out.println("开始爬取。。。");
        //获取请求
        final String url = "https://search.jd.com/Search?keyword="+keys+"&page="+num;
        //解析网页
        Document page = null;
        try {
            page = Jsoup.parse(new URL(url), 3_000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //获取块id
        Element element = page.getElementById("J_goodsList");
        Elements lis = element.getElementsByTag("li");
        lis.forEach(e -> {
            String price = e.getElementsByClass("p-price").eq(0).text();
            String img = e.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String name = e.getElementsByClass("p-name").eq(0).text();
            GoodsInfo goodsInfo = new GoodsInfo(name,price,img);
            result.add(goodsInfo);
        });
    }
}
