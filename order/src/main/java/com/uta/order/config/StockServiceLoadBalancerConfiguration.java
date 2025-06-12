package com.uta.order.config;

import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@Configuration
//public class StockServiceLoadBalancerConfiguration  {
//    @Bean
//    ReactorServiceInstanceLoadBalancer stockServiceLoadBalancer(
//            Environment environment,
//            LoadBalancerClientFactory clientFactory) {
//        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//        return new RoundRobinLoadBalancer(
//                clientFactory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
//    }
//}

