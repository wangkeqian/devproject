package com.qianma.community.service;

import com.qianma.community.Model.User;
import com.qianma.community.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/4/18
 */
@Service
public class UserService {
    @Autowired
    private UserMapper mapper;
    public void insert(User user) {
        user.setUUID();
        mapper.insert(user);
    }
    public User getById(String id){
        return mapper.getById(id);
    }

}
