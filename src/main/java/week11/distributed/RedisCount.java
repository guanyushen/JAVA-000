package week11.distributed;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

/**
 * @PROJECT_NAME: JAVA-000
 * @PACKAGE_NAME: week11.distributed
 * @NAME: RedisCount
 * @Author: guanys
 * @DATE: 1/5/21:11:40 PM
 * @Description: TODO
 * @Version: 1.0
 **/

@Component
public class RedisCount {

    private static final String INIT_COUNT_VALUE = "1";

    @Autowired
    private StringRedisTemplate redisTemplate;

    public Long increment(String key) {
        if(redisTemplate.boundValueOps(key).get() == null) {
            redisTemplate.boundValueOps(key).set(INIT_COUNT_VALUE);
            return 1L;
        } else {
            return redisTemplate.boundValueOps(key).increment(1);
        }
    }

    public String get(String key) {
        return redisTemplate.boundValueOps(key).get();
    }

    public void releaseCount(String key) {
        redisTemplate.delete(key);
    }
}
