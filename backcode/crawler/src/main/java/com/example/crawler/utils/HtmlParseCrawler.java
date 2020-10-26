package com.example.crawler.utils;

import com.example.crawler.model.GoodsInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.stream.IntStream;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/7
 */
public class HtmlParseCrawler {

    public static List<GoodsInfo> parseJDLatch(final String keys){
        CopyOnWriteArrayList<GoodsInfo> result = new CopyOnWriteArrayList<>();
        CountDownLatch countDownLatch = new CountDownLatch(9);
        IntStream.range(1,10).forEach( num ->{
            new Thread(() -> {
                parsePage(keys,num,result);
                countDownLatch.countDown();
            }).start();
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
    @Test
    public  void parsDetailPage(){
        //获取请求
        final String url = "https://item.m.jd.com/product/12555860.html";
        //解析网页
        Document page = null;

        try {
            page = Jsoup.parse(new URL(url), 3_000);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        //获取块id
        Element element = page.getElementById("priceSale");
        System.out.println(element.html());
        Element itemName = page.getElementById("itemName");
        System.out.println(itemName.html());
    }
}
