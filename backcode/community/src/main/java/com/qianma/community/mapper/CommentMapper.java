package com.qianma.community.mapper;

import com.qianma.community.Model.Comment;
import com.qianma.community.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface CommentMapper {
    Comment getById(@Param("fid") String id);
    void insert(Comment comment);

}
