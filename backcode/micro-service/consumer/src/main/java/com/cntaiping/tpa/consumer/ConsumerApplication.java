package com.cntaiping.tpa.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/7
 */
@EnableDiscoveryClient
@SpringBootApplication
@EnableFeignClients
@EnableHystrix
public class ConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerApplication.class, args);
    }
}
