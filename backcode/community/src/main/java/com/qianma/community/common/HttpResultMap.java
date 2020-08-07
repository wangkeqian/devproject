package com.qianma.community.common;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/5/1
 */
@Component
public class HttpResultMap {
    private Map<String,Object> resultMap = new HashMap<>();
    private HttpResultMap(){}
    public Map getInstance(){
        return resultMap;
    }

    public  Map setResultMap(String key, Object val){
        resultMap.put(key, val);
        return resultMap;
    }
}
