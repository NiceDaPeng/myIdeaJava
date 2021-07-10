package com.dpj;

import com.dpj.constructor.Customer;
import com.dpj.converter.Student;
import com.dpj.domain.Person;
import com.dpj.product.Product;
import com.dpj.scope.Account;
import com.dpj.service.PersonService;
import com.dpj.service.impl.PersonServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.*;

public class TestSpring {

    @Test
    public void test01(){
        //获得Spring工厂
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        Person person = (Person) ctx.getBean("person");
        System.out.println(person);
    }

    /**
     * 用于测试Spring工厂提供的其它方法
     */
    @Test
    public void test02(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);
    }

    @Test
    public void test03(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        /**
         * 如果我们使用的是通过传递类的Class对象，那么此时再Spring工厂的配置文件中
         * 只有一个bean标签的类型是Person的。
         */
//        Person person = ctx.getBean(Person.class);
//        System.out.println(person);

        /**
         * 获取在工厂配置文件中定义的所有bean的id值或者name值
         */
//        String[] beanDefinitionNames = ctx.getBeanDefinitionNames();
//        for (String str :
//                beanDefinitionNames) {
//            System.out.println("beanDefinitionName"+str);
//        }

        //根据类型来获得Spring配置文件中对应的id值/name值
//        String[] beanNamesForType = ctx.getBeanNamesForType(Person.class);
//        for (String value : beanNamesForType) {
//            System.out.println("id="+value);
//        }

        //用户判断是否存在指定id值的bean
//        if (ctx.containsBeanDefinition("person")) {
//            System.out.println("flag="+true);
//        } else {
//            System.out.println("flag="+false);
//        }
        if (ctx.containsBean("person")) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }

    @Test
    public void test04(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Person person = (Person) ctx.getBean(Person.class);
        for (String beanDefinitionName : ctx.getBeanDefinitionNames()) {
            System.out.println(beanDefinitionName);
        }
//        System.out.println(person);

    }

    /**
     * 用于测试name属性
     */
//    @Test
//    public void test05(){
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        Person person = (Person) ctx.getBean("p1");
//        System.out.println(person);
//    }

    /**
     * 用于测试Spring的DI
     *
     */
    @Test
    public void test06(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        person.setPname("good");
        person.setPpassword("good");
        System.out.println("person = " + person);
    }

    /**
     * Spring的DI（依赖注入）
     */
    @Test
    public void test07(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        System.out.println(person);
    }


    @Test
    public void test09(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        String[] emails = person.getEmails();
        for (String email : emails) {

            System.out.println(email);
        }
    }

    @Test
    public void test10(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        Set<String> tels = person.getTels();
        for (String tel : tels) {
            System.out.println(tel);
        }
    }

    @Test
    public void test11(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        List<String> strs = person.getStrs();
        for (String str : strs) {
            System.out.println(str);
        }
    }

    @Test
    public void test12(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        Map<String, String> keyValues = person.getKeyValues();
        Set<String> strings = keyValues.keySet();
        for (String string : strings) {
            String value = keyValues.get(string);
            System.out.println("value = " + value);
            System.out.println("key = " + string);
        }
    }

    @Test
    public void test13(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Person person = ctx.getBean("person", Person.class);
        Properties properties = person.getProperties();
        Enumeration<?> enumeration = properties.propertyNames();
        while (enumeration.hasMoreElements()){
            String key = (String) enumeration.nextElement();
            System.out.println("key = " + key);
            String value = (String) properties.get(key);
            System.out.println("value = " + value);
        }
    }

    @Test
    public void test14(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        PersonService service = ctx.getBean("personService", PersonServiceImpl.class);
        PersonService personService = (PersonService) ctx.getBean("personService");
        service.login("linghuchong","666");
    }


    @Test
    public void test15(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Customer customer = (Customer) ctx.getBean("customer");
        System.out.println(customer);
    }

    @Test
    public void Test16(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);
    }

//    @Test
//    public void test17(){
//        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
//        Connection conn = (Connection) ctx.getBean("conn");
//        System.out.println(conn);
//    }
    //用于测试简单对象的创建次数
    @Test
    public void test18(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        Account account1 = (Account) ctx.getBean("account");
        Account account2 = (Account) ctx.getBean("account");
        System.out.println("account1 = " + account1);
        System.out.println("account2 = " + account2);
    }

    @Test
    public void test19(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext.xml");
        Product product = (Product) ctx.getBean("product");
        ctx.close();
    }

    /**
     * 用于测试Spring配置文件参数化
     */
    @Test
    public void test20(){
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("/ApplicationContext1.xml");
        Connection conn = (Connection) ctx.getBean("conn");
        System.out.println("conn = " + conn);
    }


    /**
     * 设计一个方法用来测试自定义类型转换器
     */

    @Test
    public void test21(){
        ApplicationContext ctx = new ClassPathXmlApplicationContext("/applicationContext2.xml");
        Student student = ctx.getBean("student",Student.class);
        System.out.println(student.getName()+"--"+student.getBirthday());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String format = sdf.format(student.getBirthday());
        System.out.println(format);
    }
}
