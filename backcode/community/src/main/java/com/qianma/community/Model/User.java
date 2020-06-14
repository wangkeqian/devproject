package com.qianma.community.Model;

import lombok.Data;

import java.util.Date;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/3/22
 */
@Data
public class User {
    /*

     */
    private String clientId;
    private String name;
    private String desc;
    private int status;  //0未登录 1登录
    private String token;
    private Long gmtCreate;
    private Long gmtModified;
}
