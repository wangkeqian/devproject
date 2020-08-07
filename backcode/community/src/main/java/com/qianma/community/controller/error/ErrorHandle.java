package com.qianma.community.controller.error;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/1
 */
@Controller
@RequestMapping("error")
public class ErrorHandle {

    @GetMapping("404")
    public String notFoundPage(Model model){
        return "error/404.html";
    }


}
