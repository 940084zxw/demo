package com.zxw.service.web;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TokenUtils {

    @Autowired
    private RedisTemplate redisTemplate;

    private long timeOut=60*60;

    public String setToken(){
        String token = UUID.randomUUID().toString();
        redisTemplate.opsForValue().set(token, token, timeOut);
        return token;
    }

    public boolean findToken(String tokenName) {
        String token =(String) redisTemplate.opsForValue().get(tokenName);
        boolean result=false;
        if (StringUtils.isNotBlank(token)) {
            result=true;
            delToken(tokenName);
        }
        return result;
    }

    public void delToken(String token) {
        redisTemplate.delete(token);
    }
}
