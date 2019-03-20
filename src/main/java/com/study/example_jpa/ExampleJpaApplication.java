package com.study.example_jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
// 启用二级缓存注解
@EnableCaching
public class ExampleJpaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExampleJpaApplication.class, args);
    }
}
