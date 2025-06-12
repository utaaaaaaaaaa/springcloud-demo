package com.uta.order.mapper;

import com.uta.order.enitty.Order;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24333
* @description 针对表【order(订单表)】的数据库操作Mapper
* @createDate 2025-06-11 16:14:12
* @Entity com.uta.order.enitty.Order
*/
@Mapper
public interface OrderMapper extends BaseMapper<Order> {

}




