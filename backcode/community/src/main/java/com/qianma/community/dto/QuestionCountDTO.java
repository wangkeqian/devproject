package com.qianma.community.dto;

import lombok.Data;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/1
 */
@Data
public class QuestionCountDTO{
    private Integer viewCount = 0;
    private Integer likeCount = 0;
    private Integer commentCount = 0;
}
