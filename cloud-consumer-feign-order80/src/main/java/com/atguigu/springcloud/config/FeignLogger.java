package com.atguigu.springcloud.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @ClassName : FeignLogger
 * @Author : 50316
 * @Date: 2021/7/17 19:48
 */
@Configuration
public class FeignLogger {
    @Bean
    public Logger.Level feignFoggerLevel(){
        return  Logger.Level.FULL;
    }
}
