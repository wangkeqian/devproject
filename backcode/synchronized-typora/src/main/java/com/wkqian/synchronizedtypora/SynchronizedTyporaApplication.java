package com.wkqian.synchronizedtypora;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wkqian.synchronizedtypora.mapper")
public class SynchronizedTyporaApplication {

    public static void main(String[] args) {
        SpringApplication.run(SynchronizedTyporaApplication.class, args);
    }

}
