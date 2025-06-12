package com.uta.stock.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/reduct")
    public String reduct(){
        System.out.println("扣减库存");
        return "扣减库存" + port;
    }

    @PostMapping("/{id}")
    public String add(@PathVariable Integer id){
        System.out.println("id: "+ id);
        return id+ "add";
    }

}
