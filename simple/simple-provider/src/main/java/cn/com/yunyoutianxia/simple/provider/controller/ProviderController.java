package cn.com.yunyoutianxia.simple.provider.controller;

import cn.com.yunyoutianxia.simple.provider.entity.User;
import cn.com.yunyoutianxia.simple.provider.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanyp on 2019/3/11
 */
@RestController
public class ProviderController {

    @Value("${server.port}")
    private Integer port;

    @Autowired
    private UserService userService;

    @PostMapping("/index")
    public void index(@RequestBody User user) {
        int index= userService.index(user);
        System.out.println(index);
        System.out.println(new Gson().toJson(user));
    }
}
