package com.example.api.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/7
 */
@Data
@AllArgsConstructor
public class GoodsInfo {
    private String name;
    private String price;
    private String img;

}
