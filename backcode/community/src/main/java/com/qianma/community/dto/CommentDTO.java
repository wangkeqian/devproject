package com.qianma.community.dto;

import com.qianma.community.myenum.CommentType;
import lombok.Data;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/2
 */
@Data
public class CommentDTO {
    public CommentType commentType;
    public String parentId;
    public String comment;
}
