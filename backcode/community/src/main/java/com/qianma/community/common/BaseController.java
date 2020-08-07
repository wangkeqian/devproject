package com.qianma.community.common;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Map;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/1
 */
public abstract class BaseController {
    @Autowired(required=true)
    protected HttpResultMap resultMap;

}
