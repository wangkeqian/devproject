package com.qianma.community.myenum;

import lombok.Data;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/2
 */

public enum CommentType {
    FIRSTLEVEL("一级评论",1),
    SECONDLEVEL("二级评论",2);

    private String desc;
    private Integer value;

    CommentType() {
    }

    CommentType(String desc, Integer value) {
        this.desc = desc;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }
    public static CommentType getEnum(Integer value){
        CommentType resultEnum=null;
        CommentType[] enumAry=CommentType.values();
        for(int i=0;i<enumAry.length;i++){
            if(enumAry[i].getValue()==value){
                resultEnum=enumAry[i];
                break;
            }
        }
        return resultEnum;
    }

}
