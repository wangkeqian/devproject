package com.example.wangkq.learnspringsources.spring;

import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;
import sun.rmi.rmic.iiop.ClassPathLoader;

/**
 * TODO 请说明此类的作用
 *
 * @author wangkq
 * @date 2020/9/28
 */
public class SpringSource {
    public static void main(String[] args) {
        XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
        User bean = xmlBeanFactory.getBean(User.class);

    }
}
