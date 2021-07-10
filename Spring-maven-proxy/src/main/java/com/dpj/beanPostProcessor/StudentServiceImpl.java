package com.dpj.beanPostProcessor;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class StudentServiceImpl implements StudentService, BeanPostProcessor {

    @Override
    public void regist(Student stu) {
        System.out.println("StudentServiceImpl.regist");
    }

    @Override
    public void login(String name, String password) {
        System.out.println("StudentServiceImpl.login");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        if (bean instanceof Student){
            Student stu = (Student)bean;
            System.out.println("bean = " + bean);
        }
        return bean;
    }
}
