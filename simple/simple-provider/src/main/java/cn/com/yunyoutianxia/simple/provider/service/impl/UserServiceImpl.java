package cn.com.yunyoutianxia.simple.provider.service.impl;

import cn.com.yunyoutianxia.simple.provider.entity.Member;
import cn.com.yunyoutianxia.simple.provider.mapper.UserMapper;
import cn.com.yunyoutianxia.simple.provider.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tanyp on 2019/3/13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int index(Member member) {
        return userMapper.insert(member);
    }
}
