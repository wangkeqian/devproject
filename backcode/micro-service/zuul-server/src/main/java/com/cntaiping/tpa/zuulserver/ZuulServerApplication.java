package com.cntaiping.tpa.zuulserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/7
 */
@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulServerApplication {
    public static void main(String[] args) {
        SpringApplication.run( ZuulServerApplication.class, args );
    }
}
