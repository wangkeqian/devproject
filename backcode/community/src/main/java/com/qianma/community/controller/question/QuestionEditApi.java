package com.qianma.community.controller.question;

import com.qianma.community.Model.Question;
import com.qianma.community.Model.User;
import com.qianma.community.service.QuestionService;
import com.qianma.community.utils.SystemUtil;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/4/18
 */
@Controller
@RequestMapping("/question/edit/*")
public class QuestionEditApi {
    @Autowired
    QuestionService questionService;

    @GetMapping("/form")
    public String questionEdit(Model model){
        model.addAttribute("data",new Question());
        return "question/questionEdit";
    }

    @PostMapping("/save")
    @ResponseBody
    public Map save(Model model, Question question){
        HashMap<String, Object> resultMap = new HashMap<>();
 /*       if (SystemUtil.getLoginUser() == null){
            model.addAttribute("data",question);
            resultMap.put("STATE","FAIL");
            resultMap.put("MSG","");
            return resultMap;
        }*/
        questionService.createOrUpdate(question);
        resultMap.put("id",question.getId());
        resultMap.put("STATE","SUCCESS");
        resultMap.put("MSG","");
        return resultMap;
    }
    @GetMapping("/{id}")
    public String edit(@PathVariable String id,Model model){
        model.addAttribute("data",questionService.getQueUsr(id));
        return "question/questionEdit";
    }



}
