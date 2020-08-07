package com.qianma.community.Model;

import com.qianma.community.common.DataEntity;
import com.qianma.community.myenum.CommentType;
import lombok.Data;

/**
 * 问题评论
 *
 * @author wangkq
 * @date 2020/5/2
 */
@Data
public class Comment extends DataEntity {
    public CommentType commentType;
    public String parentId;
    public String comment;
    public Integer likeCount;
}
