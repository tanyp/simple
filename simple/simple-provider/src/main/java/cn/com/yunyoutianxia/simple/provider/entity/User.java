package cn.com.yunyoutianxia.simple.provider.entity;

import lombok.Data;

/**
 * Created by tanyp on 2019/3/11
 */
@Data
public class User {
    private Long id;
    private String name;
    private Integer age;
    private String email;
}