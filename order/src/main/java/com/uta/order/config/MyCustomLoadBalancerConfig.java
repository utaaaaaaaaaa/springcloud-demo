package com.uta.order.config;

import org.springframework.cloud.loadbalancer.core.ReactorServiceInstanceLoadBalancer;
import org.springframework.cloud.loadbalancer.core.RoundRobinLoadBalancer;
import org.springframework.cloud.loadbalancer.core.ServiceInstanceListSupplier;
import org.springframework.cloud.loadbalancer.support.LoadBalancerClientFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

//@Configuration
//public class MyCustomLoadBalancerConfig {
//    @Bean
//    ReactorServiceInstanceLoadBalancer loadBalancer(Environment environment,
//                                                    LoadBalancerClientFactory factory) {
//        String name = environment.getProperty(LoadBalancerClientFactory.PROPERTY_NAME);
//        return new RoundRobinLoadBalancer(factory.getLazyProvider(name, ServiceInstanceListSupplier.class), name);
//    }
//}

