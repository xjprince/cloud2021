package com.atguigu.springcloud.service;

import org.springframework.stereotype.Component;

/**
 * @ClassName : PaymentFallbackService
 * @Author : 50316
 * @Date: 2021/7/17 23:53
 */
@Component
public class PaymentFallbackService implements PaymentHystrixService{
    @Override
    public String paymentInfo_ok(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_OK ,o(╥﹏╥)o";
    }

    @Override
    public String paymentInfo_timeout(Integer id) {
        return "-----PaymentFallbackService fall back-paymentInfo_TimeOut ,o(╥﹏╥)o";
    }
}
