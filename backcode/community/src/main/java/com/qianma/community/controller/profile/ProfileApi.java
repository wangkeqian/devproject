package com.qianma.community.controller.profile;

import com.github.pagehelper.PageInfo;
import com.qianma.community.common.DataEntity;
import com.qianma.community.service.ProfileService;
import com.qianma.community.service.QuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/4/21
 */
@Controller
@RequestMapping("/profile/*")
public class ProfileApi {

    @Autowired
    QuestionService questionService;

    @Autowired
    ProfileService profileService;
    @GetMapping("/deal/{url}")
    public String myQuestion(@PathVariable("url")String url,  Model model){
        PageInfo<? extends DataEntity> questionList = questionService.getPageListData(1,6);
        model.addAttribute("pageInfo",questionList);
        model.addAttribute("title",profileService.getCurrentUrlCN(url));
        return "/profile/"+url;
    }
}
