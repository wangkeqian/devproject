package com.qianma.community.utils;

import com.qianma.community.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.annotation.PostConstruct;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/4/18
 */
@Component
public class SystemUtil {
    @Autowired
    public RedisUtil redisUtilOg;
    private static RedisUtil redisUtil;
    private static String addressUrl;
    @PostConstruct
    public void init(){
        redisUtil = redisUtilOg;
        addressUrl = address;
    }
    @Value("${github.client.address}")
    public String address;

    public static User getLoginUser(){
        HttpServletRequest request =  ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        Cookie[] cookies = request.getCookies();
        String token = "";
        User user = null;
        if (cookies != null){
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("userToken")){
                    String tokenCookies = cookie.getValue();
                    String clientId = tokenCookies.split("_")[0];
                    token = tokenCookies.split("_")[1];
                    user = (User) redisUtil.hget("user", clientId);
                    break;
                }
            }
        }
        if (!(user != null && user.getStatus()==1 && user.getToken().equals(token))){
            user = null;
        }
        return user;
    }
}
