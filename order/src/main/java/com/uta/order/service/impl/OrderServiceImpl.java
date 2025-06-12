package com.uta.order.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.order.enitty.Order;
import com.uta.order.service.OrderService;
import com.uta.order.mapper.OrderMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
* @author 24333
* @description 针对表【order(订单表)】的数据库操作Service实现
* @createDate 2025-06-11 16:14:12
*/
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order>
    implements OrderService{

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public Order create(Order order) {
        return order;
    }
}




