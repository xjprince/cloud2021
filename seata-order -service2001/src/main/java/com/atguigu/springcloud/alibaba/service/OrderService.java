package com.atguigu.springcloud.alibaba.service;

import com.atguigu.springcloud.alibaba.domain.Order;

/**
 * @ClassName : OrderService
 * @Author : 50316
 * @Date: 2021/5/29 0:31
 */
public interface OrderService {
    void create(Order order);
}
