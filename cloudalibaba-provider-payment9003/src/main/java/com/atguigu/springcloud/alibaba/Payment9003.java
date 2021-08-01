package com.atguigu.springcloud.alibaba;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @ClassName : Payment9003
 * @Author : 50316
 * @Date: 2021/7/31 13:21
 */
@SpringBootApplication
@EnableDiscoveryClient
public class Payment9003 {
    public static void main(String[] args) {
        SpringApplication.run(Payment9003.class, args);
    }
}
