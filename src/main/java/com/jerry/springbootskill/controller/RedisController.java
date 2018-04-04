package com.jerry.springbootskill.controller;

import com.jerry.springbootskill.domain.SysUser;
import com.jerry.springbootskill.util.RedisUtil;
import com.jerry.springbootskill.util.ResultVOUtil;
import com.jerry.springbootskill.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private RedisUtil redisUtil;

    private static final String KEY_USER = "sys:user";

    @RequestMapping("/test")
    public ResultVO test() {
        redisTemplate.opsForValue().set("test_cache", "你好");
        return ResultVOUtil.success(redisTemplate.opsForValue().get("test_cache"));
    }

    @RequestMapping("/testUser")
    public ResultVO testUser() {

        redisUtil.set(KEY_USER, new SysUser());

        return ResultVOUtil.success(redisUtil.get(KEY_USER));
    }
}