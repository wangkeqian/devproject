package com.qianma.community.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/3/22
 */
@Controller
public class IndexApi {

    @GetMapping("/")
    public String index(){


        return "index";
    }
}
