package com.wkqian.synchronizedtypora.advice;

import com.wkqian.synchronizedtypora.common.Result;
import com.wkqian.synchronizedtypora.model.FileInfo;
import com.wkqian.synchronizedtypora.model.SyncInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.io.File;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/8/5
 */
@Aspect
@Component
public class syncFilter {
    // 统一切点,对com.hangtian.admin.controller及其子包中所有的类的所有方法切面
    @Pointcut("execution(public * com.wkqian.synchronizedtypora.service.*.*(..))")
    public void Pointcut() {}


/*    @Before("Pointcut()")
    public void before(JoinPoint joinPoint){
        Object args[] = joinPoint.getArgs();
        MethodSignature sig = (MethodSignature)joinPoint.getSignature();
        Method method = sig.getMethod();
        System.out.println(method.getName());
    }*/

    @Around("Pointcut()")
    public Object doAfterReturning(ProceedingJoinPoint joinPoint){
        System.out.println("进来了");
        Result proceed = null;
        long startTime = System.currentTimeMillis();
        try {
            //执行方法
            proceed = (Result)joinPoint.proceed();
            System.out.println("执行结束");
        } catch (Throwable throwable) {

        }
        long endTime = System.currentTimeMillis();
        FileInfo fileInfo = new FileInfo();
        SyncInfo syncInfo = new SyncInfo();
        File data = (File) proceed.getData();
        fileInfo.setFileName(data.getName());
        fileInfo.setFilePath(data.getPath());
        fileInfo.setFileType(data.getName().split(".")[1]);
        fileInfo.setFileSize(data.getTotalSpace());
        syncInfo.setFileName(data.getName());
        syncInfo.setSyncTime(endTime-startTime);
        syncInfo.setIpAddress(getIpAddress());
        syncInfo.setSyncStatus(proceed.getCode()==1);
        return proceed;
    }

    public String getIpAddress() {
        InetAddress ip4 = null;
        try {
            ip4 = Inet4Address.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        return ip4.getHostAddress();
    }
/*    @AfterReturning(value="Pointcut()",returning="rvt")
    public void after(JoinPoint joinPoint,Object rvt){
        System.out.println("后置增强开始作业。。。");
        MethodSignature sig1 = (MethodSignature)joinPoint.getSignature();
        Method method1 = sig1.getMethod();
        Parameter[] parameters = method1.getParameters();
        System.out.println(1);
    }*/
}
