package com.uta.order.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.uta.order.feignService.StockFeignService;
import com.uta.order.handler.blockHandlerForAddOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/order")
@RefreshScope //nacos配置中心修改不需要重启自动修改
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private StockFeignService stockFeignService;

    @Value("${author}")
    private String author;

    @Value("${db.mysql}")
    private String mysql;

    private static final String ADD_RESOURCE = "OrderController.add";
    private static final String DEGREADE_RESOURCE = "OrderController.degrade";

    @GetMapping("/add")
    @SentinelResource(value = ADD_RESOURCE
            ,blockHandler = "blockHandlerForAddOrder"
            ,blockHandlerClass = blockHandlerForAddOrder.class
            , fallback = "blockFallback")
//    Sentinel 支持通过 @SentinelResource 注解定义资源并配置 blockHandler 和 fallback 函数来进行限流之后的处理
//    blockhandler处理流控+熔断降级，而fallback处理接口发生的异常
    public String add(){
        System.out.println("下单成功");
//        String reduct = restTemplate.getForObject("http://stock-service/stock/reduct", String.class);
//        System.out.println(reduct);
        String msg = stockFeignService.reduct();
        stockFeignService.add(1);
        return author + ", hello world" + msg + " "+ mysql;
    }

    // Fallback 函数，函数签名与原函数一致或加一个 Throwable 类型的参数.
    public String blockFallback() {
        System.out.println("fallback---");
        return "Halooooo, fallback!";
    }

    @GetMapping("/degrade")
    @SentinelResource(value = DEGREADE_RESOURCE
            ,blockHandler = "blockHandlerForAddOrder"
            ,blockHandlerClass = blockHandlerForAddOrder.class // 处理流控+熔断
            , fallback = "blockFallback")
//,exceptionsToIgnore = RuntimeException.class) // 禁止fallback捕获RuntimeException
    public String degrade(){
        throw new RuntimeException("exception");
    }

//    // Block 异常处理函数，参数最后多一个 BlockException，其余与原函数一致.
//    public String blockHandlerForAddOrder(BlockException ex) {
//        // Do some log here.
//        ex.printStackTrace();
//        return "Oops, error occurred at ";
//    }

//    //流控规则处理
//    @PostConstruct
//    private static void initFlowQpsRule() {
//        List<FlowRule> rules = new ArrayList<>();
//        FlowRule rule1 = new FlowRule();
//        rule1.setResource(ADD_RESOURCE);
//        // Set max qps to 20
//        rule1.setCount(1);
//        rule1.setGrade(RuleConstant.FLOW_GRADE_QPS);
//        rule1.setLimitApp("default");
//        rules.add(rule1);
//        FlowRuleManager.loadRules(rules);
//    }




}
