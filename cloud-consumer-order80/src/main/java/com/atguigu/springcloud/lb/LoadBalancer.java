package com.atguigu.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

/**
 * @ClassName : LoadBalancer
 * @Author : 50316
 * @Date: 2021/7/17 16:17
 */
public interface LoadBalancer {
    //获取eureka上的活着的机器总数
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);
}
