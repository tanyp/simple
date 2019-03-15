package cn.com.yunyoutianxia.simple.provider.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * Created by tanyp on 2019/3/14
 */
@Data
public class Member implements Serializable {
    private Long id;
    private String name;
    private String birthday;
    private String salt;
    private String pwd;
    private String email;
    private String mobile;
}
