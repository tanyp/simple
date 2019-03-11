package cn.com.yunyoutianxia.simple.consumer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by tanyp on 2019/3/11
 */
@RestController
public class ConsumerController {
    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/say/hello")
    public String sayHello(String hello){
        return restTemplate.getForObject( "http://simple-provider/index?hello=" + hello, String.class);
    }
}
