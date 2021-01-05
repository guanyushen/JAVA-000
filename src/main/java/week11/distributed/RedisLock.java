package week11.distributed;


import redis.clients.jedis.Jedis;

import java.util.Collections;

/**
 * @PROJECT_NAME: JAVA-000
 * @PACKAGE_NAME: week11
 * @NAME: RedisLock
 * @Author: guanys
 * @DATE: 1/5/21:11:39 PM
 * @Description: TODO
 * @Version: 1.0
 **/
public class RedisLock {

    private static final String LOCK_SUCCESS = "OK";
    private static final String SET_IF_NOT_EXIST = "NX";
    private static final String SET_WITH_EXPIRE_TIME = "PX";

    private static final Long RELEASE_SUCCESS = 1L;

    /**
     * 获取锁
     *
     * @param jedis      客户端
     * @param lockKey    锁
     * @param requestId  请求标识
     * @param expireTime 过期时间
     * @return 是否获取成功
     */
    public static boolean getLock(Jedis jedis, String lockKey, String requestId, int expireTime) {
        String result = jedis.set(lockKey, requestId, SET_IF_NOT_EXIST, SET_WITH_EXPIRE_TIME, expireTime);

        return LOCK_SUCCESS.equals(result);
    }

    /**
     * 释放锁
     *
     * @param jedis     客户端
     * @param lockKey   锁
     * @param requestId 请求标识
     * @return 是否成功
     */
    public static boolean releaseLock(Jedis jedis, String lockKey, String requestId) {
        String script = "if redis.call('get', KEYS[1]) == ARGV[1] then return redis.call('del', KEYS[1]) else return 0 end";
        Object result = jedis.eval(script, Collections.singletonList(lockKey), Collections.singletonList(requestId));

        return RELEASE_SUCCESS.equals(result);
    }
}
