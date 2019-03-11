package cn.com.yunyoutianxia.simple.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SimpleConsumerWebfluxApplication {
    public static void main(String[] args) {
        SpringApplication.run(SimpleConsumerWebfluxApplication.class, args);
    }

    @Bean
    @LoadBalanced
    public WebClient.Builder wb() {
        return WebClient.builder();
    }
}
