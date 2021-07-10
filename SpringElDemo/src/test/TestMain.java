package test;

import domain.Computer;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {
    public static void main(String[] args) {
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Computer computer = (Computer) factory.getBean("computer");
        System.out.println(computer.getBrand()+"--"+computer.getModel()+"--"+computer.getPrice()+"--"+computer.getLogo());
    }
}
