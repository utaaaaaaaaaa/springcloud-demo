package com.uta.order.service;

import com.uta.order.enitty.Order;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 24333
* @description 针对表【order(订单表)】的数据库操作Service
* @createDate 2025-06-11 16:14:12
*/
public interface OrderService extends IService<Order> {

    Order create(Order order);

}
