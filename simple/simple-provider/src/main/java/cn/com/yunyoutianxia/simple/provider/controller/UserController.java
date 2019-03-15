package cn.com.yunyoutianxia.simple.provider.controller;

import cn.com.yunyoutianxia.simple.provider.entity.Member;
import cn.com.yunyoutianxia.simple.provider.service.UserService;
import com.google.gson.Gson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanyp on 2019/3/14
 */
@RestController
public class UserController {

    @Autowired
    private UserService us;

    @PostMapping("/login")
    public void login(@RequestBody Member member) {
        int index = us.index(member);
        System.out.println("index = " + index);
        System.out.println(new Gson().toJson(member));
    }

    @PostMapping("/logout")
    public void logout(@RequestBody Member member) {
        System.out.println(new Gson().toJson(member));
    }

}
