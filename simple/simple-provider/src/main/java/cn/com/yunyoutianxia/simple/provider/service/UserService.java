package cn.com.yunyoutianxia.simple.provider.service;

import cn.com.yunyoutianxia.simple.provider.entity.Member;

/**
 * Created by tanyp on 2019/3/13
 */
public interface UserService {
    int register(Member member);

    int login(Member member);

    int logout(Member member);

    int update(Member member);

    int pwd(Member member);
}
