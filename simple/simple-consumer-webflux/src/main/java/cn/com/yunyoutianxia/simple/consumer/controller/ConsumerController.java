package cn.com.yunyoutianxia.simple.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

/**
 * Created by tanyp on 2019/3/11
 */
@RestController
public class ConsumerController {

    @Autowired
    private WebClient.Builder wb;

    @GetMapping("/say/hello")
    public Mono<String> sayHello(String hello) {
        return wb.build()
                .get()
                .uri("http://simple-provider/index?hello=" + hello)
                .retrieve()
                .bodyToMono(String.class);
    }
}
