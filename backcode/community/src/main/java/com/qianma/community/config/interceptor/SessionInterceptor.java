package com.qianma.community.config.interceptor;

import com.qianma.community.Model.User;
import com.qianma.community.utils.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/4/25
 */

@Service
public class SessionInterceptor implements HandlerInterceptor {

    @Autowired
    RedisUtil redisUtil;
    @Value("${github.client.address}")
    public String address;
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
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
        request.getSession().setAttribute("user",user);
        request.getSession().setAttribute("address",address);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
