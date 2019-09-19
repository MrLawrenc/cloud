package com.gtdq.consumer.consumer.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @author  : LiuMing
 * @date : 2019/8/14 11:57
 * @description :   TODO
 */
@Configuration
public class RibbonConfig {

    @LoadBalanced   // 配置客户端负载均衡
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}


