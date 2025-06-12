package com.uta.order.config;

import com.alibaba.csp.sentinel.annotation.aspectj.SentinelResourceAspect;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRule;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PostMapping;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class SentinelConfig {

//    @Bean
//    public SentinelResourceAspect sentinelResourceAspect() {
//        return new SentinelResourceAspect();
//    }
//      springcloudAlibaba可以不进行配置

    @PostConstruct
    public void initFlowRules() {
        List<FlowRule> rules = new ArrayList<>();

        // 订单服务流控
        rules.add(createFlowRule("OrderController.add", 1)); // QPS=100
        rules.add(createFlowRule("OrderController.degrade", 2));

        // 库存服务流控
        rules.add(createFlowRule("StockController.reduce", 20));

        FlowRuleManager.loadRules(rules);
    }

    @PostConstruct
    public void initDegradeRules() {
        List<DegradeRule> rules = new ArrayList<>();

        // 降级规则
        rules.add(createDegradeRule("OrderController.add", 2));
        rules.add(createDegradeRule("OrderController.degrade", 3));

        DegradeRuleManager.loadRules(rules);
    }

    private FlowRule createFlowRule(String resource, int qps) {
        FlowRule rule = new FlowRule();
        rule.setResource(resource);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS); //设置流控规则：qps
        rule.setCount(qps);
        rule.setLimitApp("default"); //所有请求都受此规则限制
        return rule;
    }

    private DegradeRule createDegradeRule(String resource, int qps) {
        DegradeRule rule = new DegradeRule();
        rule.setResource(resource);
        rule.setGrade(RuleConstant.DEGRADE_GRADE_EXCEPTION_COUNT); //设置策略规则；异常数
        rule.setCount(qps); //异常数
        rule.setMinRequestAmount(2); //触发熔断最小请求数，也就是1次请求出现两次异常不会触发熔断降级
        rule.setStatIntervalMs(60*1000); //在多长时间段内触发异常会熔断，默认1s
        rule.setTimeWindow(10); //降级时间窗口，在触发降级策略后这个窗口时间段内10s内都会触发降级策略
        return rule;
    }

}
