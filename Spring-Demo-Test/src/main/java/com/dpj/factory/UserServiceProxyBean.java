package com.dpj.factory;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class UserServiceProxyBean implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("UserServiceProxyBean.invoke");
                Object ret = method.invoke(bean,args);
                return ret;
            }
        };
        Object ret = Proxy.newProxyInstance(UserServiceProxyBean.class.getClassLoader(), bean.getClass().getInterfaces(), handler);
        return ret;
    }
}
