package com.qianma.learningjava8.chepter1;

import lombok.Data;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/24
 */
@Data
public class AppleChoose {

    private String color;
    private int weight;

    private interface AppleFilter{
        boolean filter(AppleChoose appleChoose);
    }

    public List<AppleChoose>
}
