package com.qianma.community.service;

import org.springframework.stereotype.Service;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/4/21
 */
@Service
public class ProfileService {

    public String getCurrentUrlCN(String url) {
        String result = "";
        if ("myQuestion".equals(url)){
            result += "我的问题";
        }else if ("replies".equals(url)) {
            result += "最新回复";
        }else if ("roughNotBook".equals(url)) {
            result += "我的草稿";
        }else if ("focusQuestion".equals(url)) {
            result += "我关注的问题";
        }else if ("focusTopic".equals(url)) {
            result += "我关注的话题";
        }
        return result;
    }
}
