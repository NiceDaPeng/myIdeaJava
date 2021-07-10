package com.dpj;

import com.dpj.domain.Student;
import com.dpj.factory.MainConfiguration;
import com.dpj.factory.MyFactoryBean;
import com.dpj.service.StudentService;
import com.dpj.service.impl.StudentServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Student student = ctx.getBean("student", Student.class);
        student.setName("令狐冲");
        student.setPassword("linghuchong");
        student.setAge(30);
        System.out.println(student);
    }

    /**
     *
     */
    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        StudentService stuService = (StudentServiceImpl) ctx.getBean("studentServiceImpl");
        stuService.login("linghuchong","aaa");
        Student student = (Student) ctx.getBean("student");
        System.out.println(student);
    }


    @Test
    public void test3(){
        ApplicationContext ctx = new AnnotationConfigApplicationContext(MainConfiguration.class);
        Object jdbcTemplate = ctx.getBean("getJdbcTemplate");
        System.out.println(jdbcTemplate);
    }
}
