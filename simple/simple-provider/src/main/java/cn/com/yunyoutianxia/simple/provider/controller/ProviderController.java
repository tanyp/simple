package cn.com.yunyoutianxia.simple.provider.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanyp on 2019/3/11
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private Integer port;

    @GetMapping("/index")
    public String index(String hello) {
        return "hello " + hello + port;
    }
}
