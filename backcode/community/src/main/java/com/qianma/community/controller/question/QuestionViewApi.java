package com.qianma.community.controller.question;

import com.github.pagehelper.PageInfo;
import com.qianma.community.Model.Question;
import com.qianma.community.common.BaseController;
import com.qianma.community.common.DataEntity;
import com.qianma.community.dto.QueUsrDTO;
import com.qianma.community.service.QuestionService;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/4/18
 */
@Controller
@RequestMapping("/question/view/*")
public class QuestionViewApi extends BaseController {
    @Autowired
    QuestionService questionService;


    @GetMapping("/{id}")
    public String searchQuestion(@PathVariable String id, Model model){
        questionService.setCount(id,"view");
        QueUsrDTO queUsrDTO = questionService.getQueUsr(id);
        model.addAttribute("data",queUsrDTO);
        return "question/questionView.html";
    }
}
