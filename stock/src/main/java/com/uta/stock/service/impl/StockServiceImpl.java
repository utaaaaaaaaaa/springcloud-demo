package com.uta.stock.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.uta.stock.entity.Stock;
import com.uta.stock.service.StockService;
import com.uta.stock.mapper.StockMapper;
import org.springframework.stereotype.Service;

/**
* @author 24333
* @description 针对表【stock(商品库存表)】的数据库操作Service实现
* @createDate 2025-06-11 16:15:20
*/
@Service
public class StockServiceImpl extends ServiceImpl<StockMapper, Stock>
    implements StockService{

}




