package cn.com.yunyoutianxia.simple.provider.controller;

import cn.com.yunyoutianxia.simple.provider.entity.User;
import cn.com.yunyoutianxia.simple.provider.mapper.UserMapper;
import com.alibaba.druid.stat.DruidStatManagerFacade;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by tanyp on 2019/3/12
 */
@RestController
public class DruidStatController {
    @GetMapping("/druid/stat")
    public Object druidStat() {
        // DruidStatManagerFacade#getDataSourceStatDataList 该方法可以获取所有数据源的监控数据，
        // 除此之外 DruidStatManagerFacade 还提供了一些其他方法，你可以按需选择使用。
        return DruidStatManagerFacade.getInstance().getDataSourceStatDataList();
    }

    @Resource
    private UserMapper userMapper;

    @GetMapping("/insert")
    public void insert() {
        System.out.println(("----- insert method test ------"));
        User user = new User();
        user.setId(2L);
        user.setName("有只猪在睡觉");
        user.setAge(17);
        user.setEmail("652630339@qq.com");
        int num = userMapper.insert(user);
        System.out.println(num);
    }

    @GetMapping("/select")
    public void select() {
        System.out.println(("----- select method test ------"));
        List<User> userList = userMapper.selectList(null);
        for (int i = 0; i < userList.size(); i++) {
            User user = userList.get(i);
            System.out.println(user.getName());
        }
    }

    @GetMapping("/update")
    public void update() {
        System.out.println(("----- update method test ------"));
        User user = userMapper.selectById("1");
        System.out.println(user.getName());
        user.setName("谭友平");
        int num = userMapper.updateById(user);
        System.out.println(num);
    }

    @GetMapping("/delete")
    public void delete() {
        System.out.println(("----- delete method test ------"));
        int size = userMapper.deleteById("2");
        System.out.println(size);
    }

}
