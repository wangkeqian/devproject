package com.cntaiping.tpa.consumersecond;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
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
public class ConsumerSecondApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConsumerSecondApplication.class, args);
    }
}
