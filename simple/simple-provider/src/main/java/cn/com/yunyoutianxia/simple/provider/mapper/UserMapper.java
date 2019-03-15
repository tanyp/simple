package cn.com.yunyoutianxia.simple.provider.mapper;

import cn.com.yunyoutianxia.simple.provider.entity.Member;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

/**
 * Created by tanyp on 2019/3/11
 */
@Repository
public interface UserMapper extends BaseMapper<Member> {
}
