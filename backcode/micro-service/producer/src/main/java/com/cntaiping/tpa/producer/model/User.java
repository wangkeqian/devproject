package com.cntaiping.tpa.producer.model;

import java.util.Date;

/*
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/8
 */
public class User {
    private String id;
    private String name;
    private int age;
    private Date createTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
