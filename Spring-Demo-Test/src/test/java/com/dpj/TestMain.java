package com.dpj;

import com.dpj.dao.UserDao;
import com.dpj.dao.impl.UserDaoImpl;
import com.dpj.domain.User;
import com.dpj.factory.UserDaoFactory;
import com.dpj.proxy.UserService;
import com.dpj.proxy.UserServiceImpl;
import com.dpj.proxy.UserServiceProxy;
import com.dpj.util.MyUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Properties;
import java.util.Set;


public class TestMain {

    @Test
    public void test1(){
//        try {
//            Properties pro = new Properties();
//            pro.load(Thread.currentThread().getContextClassLoader().getResourceAsStream("first.properties"));
//            String value = (String) pro.get("one");
//            Class<?> clazz = Class.forName(value);
//            UserDao userDao = (UserDao) clazz.newInstance();
//            System.out.println(userDao);
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }

//        UserDao userDao = (UserDao) UserDaoFactory.getBean("one");
//        userDao.insert(new User());
//        userDao.login("linghuchong","111");

    }

    @Test
    public void test(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        User user = (User) ctx.getBean("user");
        System.out.println(user);
        System.out.println();
    }

    @Test
    public void test2(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext.xml");
        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
        for (String beanDefinitionName : beanDefinitionNames) {
            System.out.println(beanDefinitionName);
        }

        Map<String, User> beansOfType = ctx.getBeansOfType(User.class);
        Set<Map.Entry<String, User>> entries = beansOfType.entrySet();
        for (Map.Entry<String, User> entry : entries) {
            System.out.println("entry = " + entry);
        }

    }

    @Test
    public void test3(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user = (User) ctx.getBean("user");
        System.out.println("user.getName() = " + user.getName());
        System.out.println("user.getArrays() = " + user.getArrays());
        System.out.println("user.getMap() = " + user.getMap());

    }

    @Test
    public void test4 () {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        MyUtil myutil = (MyUtil) ctx.getBean("&myutil");
        System.out.println(myutil instanceof Connection);
    }

    @Test
    public void test5(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println(conn instanceof Connection);
    }

    @Test
    public void test6(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Connection conn = (Connection) ctx.getBean("connInstance");
        System.out.println(conn instanceof Connection);
    }

    @Test
    public void test7(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User user1 = (User) ctx.getBean("user1");
        System.out.println(user1.getBirthday());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(user1.getBirthday());
        System.out.println(format);
    }

    @Test
    public void test8(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService serviceProxy = (UserService) ctx.getBean("serviceProxy");
        serviceProxy.login("linghuchong","aaaaaa");
        serviceProxy.regist(new User());
    }

    @Test
    public void test9(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Object userService = ctx.getBean("userService");
        System.out.println(userService.getClass());

    }

    @Test
    public void test10(){
        InvocationHandler handler = new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("---log---");
                Object ret = method.invoke(proxy,args);
                System.out.println("after--log");
                return ret;
            }
        };
        com.dpj.dynamicproxy.UserService service = (com.dpj.dynamicproxy.UserService) new UserServiceImpl();
        com.dpj.dynamicproxy.UserService userServiceProxy = (com.dpj.dynamicproxy.UserService) Proxy.newProxyInstance(TestMain.class.getClassLoader(), service.getClass().getInterfaces(), handler);
    }

    @Test
    public void test11(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        com.dpj.dynamicproxy.UserService userService = (com.dpj.dynamicproxy.UserService) ctx.getBean("userService");
        userService.regist(new User());
        userService.login("linghuchong","aaa");
    }


}
