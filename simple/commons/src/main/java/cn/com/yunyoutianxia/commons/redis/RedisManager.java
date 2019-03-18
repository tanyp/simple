package cn.com.yunyoutianxia.commons.redis;


import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

/**
 * Created by tanyp on 2019/3/18
 */
@Component
public class RedisManager<K, V> extends RedisTemplate<K, V> {
}
