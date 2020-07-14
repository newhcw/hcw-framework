package com.hcw.framework.redis.core;

import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.connection.StringRedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * 管道用法
 * Created by @author yihui in 14:47 20/4/11.
 */
@Component
public class PipelineRedisTemplate {

    private RedisTemplate<String, String> redisTemplate;

    public PipelineRedisTemplate(RedisTemplate<String, String> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public void counter(String prefix, String key, String target) {
        // 请注意，返回的结果与内部的redis操作顺序是匹配的
        List<Object> res = redisTemplate.executePipelined(new RedisCallback<Long>() {
            @Override
            public Long doInRedis(RedisConnection redisConnection) throws DataAccessException {
                String mapKey = prefix + "_mp_" + key;
                String cntKey = prefix + "_cnt_" + target;

                redisConnection.openPipeline();
                redisConnection.incr(mapKey.getBytes());
                redisConnection.incr(cntKey.getBytes());
                return null;
            }
        });
        System.out.println(res);
    }


    /**
     * 批量查询
     * @param keys
     * @return
     */
    public List<Object> getValueByKeys(final List<String> keys) {
        if(CollectionUtils.isEmpty(keys)) {
            return null;
        }
        return redisTemplate.executePipelined(new RedisCallback<Object>() {
            @Override
            public Object doInRedis(RedisConnection connection) throws DataAccessException {
                StringRedisConnection stringRedisConn = (StringRedisConnection) connection;
                for (String key : keys) {
                    stringRedisConn.get(key);
                }
                return null;
            }
        });
    }
}