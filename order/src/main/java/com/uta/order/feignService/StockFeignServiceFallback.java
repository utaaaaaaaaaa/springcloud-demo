package com.uta.order.feignService;

import org.springframework.stereotype.Component;

//openfeign调用服务熔断降级的实现类
@Component
public class StockFeignServiceFallback implements StockFeignService{
    @Override
    public String reduct() {
        return "服务降级！！";
    }

    @Override
    public String add(Integer id) {
        return "服务降级！！";
    }
}
