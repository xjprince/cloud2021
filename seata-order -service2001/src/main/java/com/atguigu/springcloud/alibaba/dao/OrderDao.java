package com.atguigu.springcloud.alibaba.dao;

import com.atguigu.springcloud.alibaba.domain.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName : Order
 * @Author : 50316
 * @Date: 2021/8/1 10:03
 */
@Mapper
public interface OrderDao {
    // 新建订单
    void create(Order order);

    // 更新订单状态  0变1
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}
