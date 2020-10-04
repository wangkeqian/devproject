package com.cntaiping.tpa.consumer.controller;

import com.cntaiping.tpa.consumer.feignClient.ProducerClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
    @HystrixCommand(fallbackMethod = "getManageError")
    public String getManage(@PathVariable String name){
        System.out.println("路由到consumer 1");
        int i = 1/0;
        return producerClient.getMessage(name);
    }
    public String getManageError(String name){
        System.out.println("错误信息-"+name);
        return "hello "+name+",this process is error ";
    }
}
