package com.dpj;


import com.dpj.beanPostProcessor.MyBeanPostProcessor;
import com.dpj.beanPostProcessor.Student;
import com.dpj.beanPostProcessor.StudentService;
import com.dpj.dynamic.OrderService;
import com.dpj.proxy.User;
import com.dpj.proxy.UserService;
import com.dpj.proxy.UserServicePoxy;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestPoxy {

    @Test
    public void test01(){
        UserService service = new UserServicePoxy();
        service.login("linghuchong","111");
        service.regists(new User("renyingying","111"));
    }

    /**
     * 用来测试动态代理
     */
    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        com.dpj.dynamic.UserService userService = (com.dpj.dynamic.UserService) ctx.getBean("userService");
        userService.login("linghuchong","111");
        userService.regist(new User());
    }

    @Test
    public void test3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        OrderService orderService = (OrderService) ctx.getBean("orderService");
        orderService.showOrder();
    }


    @Test
    public void test4(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        MyBeanPostProcessor stuService = (MyBeanPostProcessor) ctx.getBean("beanPostProcessor");
        Student stu = (Student) ctx.getBean("stu");
    }
}
