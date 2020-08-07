package com.qianma.community.controller.question;

import com.qianma.community.Model.Comment;
import com.qianma.community.Model.User;
import com.qianma.community.dto.CommentDTO;
import com.qianma.community.service.CommentService;
import com.qianma.community.utils.DtoToPo;
import org.hibernate.validator.constraints.SafeHtml;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/2
 */
@RestController
@RequestMapping("comment")
public class CommentApi {
    @Autowired
    CommentService commentService;

    @RequestMapping("save")
    public Object saveComment(@RequestBody CommentDTO commentDto,@SessionAttribute("user") User user){
        if (user == null){

        }
        Comment comment = new Comment();
        try {
            DtoToPo.poToDto(commentDto,comment);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(comment.getGmtCreate());
        return null;
    }

}
