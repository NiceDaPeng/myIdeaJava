package com.dpj.service.impl;

import com.dpj.domain.Student;
import org.springframework.aop.MethodBeforeAdvice;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Component("serviceMethodBefore")
public class ServiceMethodBefore implements BeanPostProcessor {

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        Object ret = null;
        if (bean instanceof Student)
            System.out.println("student = " + bean);
        return ret;
    }
}
