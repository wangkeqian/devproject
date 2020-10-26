package com.example.crawler.api;

import com.example.crawler.model.GoodsInfo;
import com.example.crawler.utils.HtmlParseCrawler;

import java.io.IOException;
import java.util.List;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/7
 */
public class JsoupProcessor {
    public static void main(String[] args) throws IOException {
        parseJD("Java").forEach(System.out::println);
    }

    public static List<GoodsInfo> parseJD(String keys) throws IOException {
        return HtmlParseCrawler.parseJDLatch(keys);
    }
}
