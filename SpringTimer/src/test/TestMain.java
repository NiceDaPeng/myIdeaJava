package test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import springtimer.SpringTask;

public class TestMain {

    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("applicationContext.xml");
        SpringTask task = (SpringTask) factory.getBean("springTask");
        task.doSomthing();
    }
}
