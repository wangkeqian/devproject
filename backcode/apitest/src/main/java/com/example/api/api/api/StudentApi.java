package com.example.api.api.api;

import com.example.api.api.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2019/12/4
 */
@RestController
@EnableAutoConfiguration
public class StudentApi {
    @Autowired
    private RedisUtil redisUtil;

    @GetMapping("/getInfo")
    public String getInfo(){
        return "你好 王克千";
    }
    @PostMapping("/getInfo")
    public String getInfo(@RequestParam(value = "name", required = false) String name, @RequestParam(value = "desc", required = false) String desc){
        redisUtil.set(name,desc);
        return name+" : "+desc;
    }
}
