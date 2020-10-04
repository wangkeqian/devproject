package com.cntaiping.tpa.consumer.feignClient;

import org.springframework.stereotype.Component;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/7
 */
@Component
public class ProducerHystrix implements ProducerClient{

    @Override
    public String getMessage(String name) {

        return "连接不到服务，请重试。。。。";
    }
}
