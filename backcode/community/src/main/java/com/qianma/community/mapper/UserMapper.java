package com.qianma.community.mapper;

import com.qianma.community.Model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    User getById(@Param("fid") String id);
    void insert(User user);

}
