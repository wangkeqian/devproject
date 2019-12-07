package com.example.api.api.entity;

import lombok.Data;

import java.util.Date;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2019/12/7
 */
@Data
public class Car {
    private String id;
    private String name;
    private String desc;
    private Date createDate;

}
