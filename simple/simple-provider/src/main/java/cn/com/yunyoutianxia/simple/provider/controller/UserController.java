package cn.com.yunyoutianxia.simple.provider.controller;

import cn.com.yunyoutianxia.simple.provider.entity.Member;
import cn.com.yunyoutianxia.simple.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tanyp on 2019/3/14
 */
@RestController
@RequestMapping("/u")
public class UserController {

    @Autowired
    private UserService us;

    @Autowired
    private RedisTemplate<String, String> template;


    @PostMapping("/redis")
    public void redis() {
        ValueOperations<String, String> kvValueOperations = template.opsForValue();
        kvValueOperations.set("key","222");
        System.out.println(kvValueOperations.get("key"));
        template.delete("key");
        System.out.println(kvValueOperations.get("key"));
    }

    @PostMapping("/register")
    public void register(@RequestBody Member member) {
        int index = us.register(member);
    }

    @PostMapping("/login")
    public void login(@RequestBody Member member) {
        int index = us.login(member);
    }

    @PostMapping("/logout")
    public void logout(@RequestBody Member member) {
        int index = us.logout(member);
    }

    @PostMapping("/update")
    public void update(@RequestBody Member member) {
        int index = us.update(member);
    }

    @PostMapping("/change/pwd")
    public void pwd(@RequestBody Member member) {
        int index = us.pwd(member);
    }
}
