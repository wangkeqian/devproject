package org.javaboy.vhr.service;

import org.javaboy.vhr.mapper.PoliticsstatusMapper;
import org.javaboy.vhr.model.Politicsstatus;
import org.javaboy.vhr.utils.RedisCacheUtil;
import org.javaboy.vhr.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @作者 江南一点雨
 * @公众号 江南一点雨
 * @微信号 a_java_boy
 * @GitHub https://github.com/lenve
 * @博客 http://wangsong.blog.csdn.net
 * @网站 http://www.javaboy.org
 * @时间 2019-11-03 23:20
 */
@Service
public class PoliticsstatusService {
    @Autowired
    PoliticsstatusMapper politicsstatusMapper;
    @Autowired
    RedisUtil redisUtil;
    public List<Politicsstatus> getAllPoliticsstatus() {
        return RedisCacheUtil.get("politicsstatus",
                key -> (List<Politicsstatus>) redisUtil.get(key),
                (key) -> politicsstatusMapper.getAllPoliticsstatus(),
                (k,v) -> redisUtil.set(k,v));
    }
}
