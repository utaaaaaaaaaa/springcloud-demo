package com.uta.order.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {

    /**
     *RestTemplate 默认只是一个普通的 HTTP 客户端，它无法自动解析服务名如 stock-service）
     * 而是直接尝试 DNS 查询，导致 UnknownHostException。
     * @LoadBalanced 的作用是让 RestTemplate 具备服务发现和负载均衡能力，使其能通过Nacos/Eureka等注册中心解析服务名，并自动选择可用的服务实例。
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.build();
    }

}
