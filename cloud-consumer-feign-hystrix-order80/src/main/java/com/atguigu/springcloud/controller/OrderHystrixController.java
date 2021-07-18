package com.atguigu.springcloud.controller;

import com.atguigu.springcloud.service.PaymentHystrixService;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName : OrderHystrixController
 * @Author : 50316
 * @Date: 2021/7/17 21:49
 */
@RestController
@Slf4j
@DefaultProperties(defaultFallback = "payment_Global_fallbackMethod")
public class OrderHystrixController {
    @Resource
    private PaymentHystrixService paymentHystrixService;

    @GetMapping("/consumer/hystrix/ok/{id}")
    public String paymentInfo_ok(@PathVariable(value = "id") Integer id){
        String result= paymentHystrixService.paymentInfo_ok(id);
        return result;
    }

    /*@HystrixCommand(fallbackMethod = "paymentInfo_timeoutHandler",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
    })*/
    @HystrixCommand
    @GetMapping("/consumer/hystrix/timeout/{id}")
    public String paymentInfo_timeout(@PathVariable(value = "id") Integer id){
        String result= paymentHystrixService.paymentInfo_timeout(id);
        return result;
    }

    public String paymentInfo_timeoutHandler(Integer id){
        return "我是消费者80,支付系统繁忙,请稍后重试 o(╥﹏╥)o";
    }

    public String payment_Global_fallbackMethod(){
        return "global异常处理,请稍后重试 o(╥﹏╥)o";
    }
}
