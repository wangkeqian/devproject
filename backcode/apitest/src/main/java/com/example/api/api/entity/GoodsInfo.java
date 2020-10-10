package com.example.api.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/10/7
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class GoodsInfo implements Serializable {
    private String name;
    private String price;
    private String img;

}
