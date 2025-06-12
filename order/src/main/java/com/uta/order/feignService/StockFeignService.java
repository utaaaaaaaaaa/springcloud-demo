package com.uta.order.feignService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "stock-service",path = "/stock",fallback = StockFeignServiceFallback.class)
public interface StockFeignService {

    //声明需要调用的rest接口对应的方法
    @RequestMapping("/reduct")
    String reduct();

    @PostMapping("/{id}")
    String add(@PathVariable(name = "id") Integer id);

}
