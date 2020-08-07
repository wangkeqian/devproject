package com.qianma.community.Model;

import com.qianma.community.common.DataEntity;
import lombok.Data;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/4/18
 */
@Data
public class Question extends DataEntity {
    private String title;
    /**
     * 问题描述
     */
    private String desc;
    private String tags;
    private Integer viewCount = 0;
    private Integer likeCount = 0;
    private Integer commentCount = 0;
}
