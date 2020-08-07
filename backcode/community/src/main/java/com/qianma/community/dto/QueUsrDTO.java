package com.qianma.community.dto;

import com.qianma.community.Model.User;
import com.qianma.community.common.DataEntity;
import lombok.Data;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/4/19
 */
@Data
public class QueUsrDTO extends DataEntity {
    private String title;
    /**
     * 问题描述
     */
    private String desc;
    private String tags;
    private Integer viewCount;
    private Integer likeCount;
    private Integer commentCount;
    private User user;
}
