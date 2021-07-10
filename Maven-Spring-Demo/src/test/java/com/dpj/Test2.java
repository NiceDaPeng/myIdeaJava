package com.dpj;

import com.dpj.beanpostprocessor.Category;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test2 {

    @Test
    public void test1(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext3.xml");
        Category category = (Category) ctx.getBean("category");
        System.out.println(category.getName());
    }
}
