package cn.com.yunyoutianxia.simple.provider;

import cn.com.yunyoutianxia.simple.provider.entity.Member;
import cn.com.yunyoutianxia.simple.provider.mapper.UserMapper;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleTest {

    @Resource
    private UserMapper um;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        List<Member> members = um.selectList(null);
        Assert.assertEquals(5, members.size());
        members.forEach(System.out::println);
    }
}
