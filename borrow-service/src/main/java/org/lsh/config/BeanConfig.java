package org.lsh.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
@LoadBalancerClient(value = "userService", // 指定为userService服务，只要是调用此服务都会使用我们指定的策略
        configuration = LoanBalancerConfig.class) // 选择我们刚刚配置好的配置类
public class BeanConfig {
    @Bean
    @LoadBalanced()
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
