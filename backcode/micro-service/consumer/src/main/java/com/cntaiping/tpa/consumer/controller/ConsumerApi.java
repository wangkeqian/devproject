package com.cntaiping.tpa.consumer.controller;

import com.cntaiping.tpa.consumer.feignClient.ProducerClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/7
 */
@RestController("consumer")
public class ConsumerApi {
    @Autowired
    ProducerClient producerClient;
    @GetMapping("hello/{name}")
    public String getManage(@PathVariable String name){
        return producerClient.getMessage(name);
    }
}
