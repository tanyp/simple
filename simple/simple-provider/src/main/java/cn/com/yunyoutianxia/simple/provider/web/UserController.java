package cn.com.yunyoutianxia.simple.provider.web;

import cn.com.yunyoutianxia.commons.json.JSONResultModel;
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
    private RedisTemplate<String, String> manager;

    @GetMapping("/redis")
    public void redis(HttpServletRequest request) {
        ValueOperations<String, String> kvValueOperations = manager.opsForValue();
        Member member = new Member();
        member.setId(1L);
        kvValueOperations.set("key", "223");
        System.out.println(kvValueOperations.get("key"));
        manager.delete("key");
        System.out.println(kvValueOperations.get("key"));
        System.out.println(request.getSession().getId());
    }

    @PostMapping("/register")
    public JSONResultModel<Object> register(@RequestBody Member member) {
        JSONResultModel<Object> jrm = new JSONResultModel<>();
        int index = us.register(member);
        if (index > 0) {
            jrm.setRet(false);
        }
        return jrm;
    }

    @PostMapping("/login")
    public JSONResultModel<Object> login(@RequestBody Member member, HttpServletRequest hsr) {
        JSONResultModel<Object> jrm = new JSONResultModel<>();
        Member mb = us.login(member);
        if (mb == null) {
            jrm.setRet(false);
        }
        return jrm;
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
