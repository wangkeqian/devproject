package com.qianma.community.advice;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.*;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/7/30
 */
@Aspect
@Component
public class LogFilter {

    // 统一切点,对com.hangtian.admin.controller及其子包中所有的类的所有方法切面
    @Pointcut("execution(public * com.qianma.community.controller..*.*(..))")
    public void Pointcut() {}


    @Before("Pointcut()")
    public void before(JoinPoint joinPoint){
        Object args[] = joinPoint.getArgs();
        MethodSignature sig = (MethodSignature)joinPoint.getSignature();
        Method method = sig.getMethod();
        System.out.println(method.getName());
    }

    @Around("Pointcut()")
    public Object doAfterReturning(ProceedingJoinPoint joinPoint){
        System.out.println("进来了");
        Object proceed = null;
        try {
            //执行方法
            proceed = joinPoint.proceed();
            System.out.println("执行结束");
        } catch (Throwable throwable) {

        }
        return proceed;
    }
    @AfterReturning(value="Pointcut()",returning="rvt")
    public void after(JoinPoint joinPoint,Object rvt){
        MethodSignature sig1 = (MethodSignature)joinPoint.getSignature();
        Method method1 = sig1.getMethod();
        System.out.println(rvt.toString());
        System.out.println("after");
    }
}
