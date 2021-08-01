package com.atguigu.springcloud.alibaba.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

/**
 * @ClassName : Order
 * @Author : 50316
 * @Date: 2021/8/1 9:54
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order {
    private Long id;
    private Long userId;
    private Long ProductId;
    private Integer count;
    private BigDecimal money;
    /**
     * 订单状态: 0创建中 1已完成
     */
    private Integer status;

}
