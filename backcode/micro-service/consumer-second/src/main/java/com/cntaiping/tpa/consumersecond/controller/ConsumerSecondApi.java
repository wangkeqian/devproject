package com.cntaiping.tpa.consumersecond.controller;

import com.cntaiping.tpa.consumersecond.feignClient.ProducerClient;
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
@RestController("consumer-second")
public class ConsumerSecondApi {

    @Autowired
    ProducerClient producerClient;
    @GetMapping("hello/{name}")
    public String getManage(@PathVariable String name){
        System.out.println("路由到consumer-second");
        return producerClient.getMessage(name);
    }
}
