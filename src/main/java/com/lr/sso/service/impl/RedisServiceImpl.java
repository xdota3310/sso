package com.lr.sso.service.impl;

import com.lr.sso.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * redis服务
 *
 * @author shijie.xu
 * @since 2019年02月15日
 */
@Service
public class RedisServiceImpl implements RedisService {

    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public void put(String key, Object value) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, 24L, TimeUnit.HOURS);
    }

    @Override
    public void put(String key, Object value, long millis) {
        redisTemplate.opsForValue().set(key, value);
        redisTemplate.expire(key, millis, TimeUnit.MILLISECONDS);
    }

    @Override
    public <T> T get(String key, Class<T> type) {
        return (T) redisTemplate.boundValueOps(key).get();
    }

    @Override
    public void remove(String key) {
        redisTemplate.delete(key);
    }
}
