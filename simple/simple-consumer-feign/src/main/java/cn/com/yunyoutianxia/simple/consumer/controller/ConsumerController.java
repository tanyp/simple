package cn.com.yunyoutianxia.simple.consumer.controller;

import cn.com.yunyoutianxia.simple.consumer.service.SimpleService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by tanyp on 2019/3/11
 */
@RestController
public class ConsumerController {

    @Resource
    private SimpleService ss;

    @GetMapping("/say/hello")
    public String sayHello(String hello) {
        return ss.index(hello);
    }
}
