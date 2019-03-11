package cn.com.yunyoutianxia.simple.consumer.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by tanyp on 2019/3/11
 */
@FeignClient("simple-provider")
public interface SimpleService {
    @GetMapping("/index")
    String index(@RequestParam("hello") String name);
}
