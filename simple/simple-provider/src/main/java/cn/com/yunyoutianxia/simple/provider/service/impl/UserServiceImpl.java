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
    public int register(Member member) {
        return userMapper.insert(member);
    }

    @Override
    public int login(Member member) {
        return 0;
    }

    @Override
    public int logout(Member member) {
        return 0;
    }

    @Override
    public int update(Member member) {
        return 0;
    }

    @Override
    public int pwd(Member member) {
        return 0;
    }
}
