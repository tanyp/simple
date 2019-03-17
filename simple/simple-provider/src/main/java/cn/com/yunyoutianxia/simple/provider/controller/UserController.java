package cn.com.yunyoutianxia.simple.provider.controller;

import cn.com.yunyoutianxia.simple.provider.entity.Member;
import cn.com.yunyoutianxia.simple.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

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


    @GetMapping("/redis")
    public void redis(HttpServletRequest request) {
        ValueOperations<String, String> kvValueOperations = template.opsForValue();
        kvValueOperations.set("key","222");
        System.out.println(kvValueOperations.get("key"));
        template.delete("key");
        System.out.println(kvValueOperations.get("key"));
        System.out.println(request.getSession().getId());
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
