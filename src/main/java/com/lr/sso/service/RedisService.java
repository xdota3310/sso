package com.lr.sso.service;

/**
 * redis工具服务
 *
 * @author shijie.xu
 * @since 2019年02月15日
 */
public interface RedisService {
    void put(String key, Object value);

    void put(String key, Object value, long millis);

    <T> T get(String key, Class<T> type);

    void remove(String key);
}
