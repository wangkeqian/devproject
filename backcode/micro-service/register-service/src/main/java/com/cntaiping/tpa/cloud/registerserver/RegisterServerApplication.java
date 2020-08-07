package com.cntaiping.tpa.cloud.registerserver;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/6
 */
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class RegisterServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(RegisterServerApplication.class, args);
    }

}

