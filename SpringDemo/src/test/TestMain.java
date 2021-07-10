package test;

import controller.StudentController;
import domain.Computer;
import domain.Student;
import domain.TestBean;
import domain.TestProperties;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

public class TestMain {
    public static void main(String[] args) {

        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
//        StudentController controller = (StudentController) factory.getBean("controller");
//        controller.selectOne();
//        TestService testService = (TestService) factory.getBean("testService");

//        TestBean testBean = (TestBean) factory.getBean("testBean");
//        System.out.println(testBean.getName());
//        Computer[] computers = testBean.getComputers();
//        for (int i = 0; i < computers.length; i++) {
//            System.out.println(computers[i]);
//        }
//        String name = testBean.getName();
//        System.out.println(name);
//        Computer computer = testBean.getComputer();
//        System.out.println(computer);
//        Set<Computer> set = testBean.getSet();

//        String name = testBean.getName();
//        System.out.println(name);
//        Computer computer = testBean.getComputer();
//        System.out.println(computer);
//        System.out.println("----");
//        Set<Computer> set = testBean.getSet();
//        Iterator<Computer> iterator = set.iterator();
//        while (iterator.hasNext()){
//            Computer next = iterator.next();
//            System.out.println(next);
//        }

//        String name = testBean.getName();
//        System.out.println(name);
//        Computer computer = testBean.getComputer();
//        System.out.println(computer);
//        Map<String, String> map = testBean.getMap();
//        Set<Map.Entry<String, String>> entries = map.entrySet();
//        Iterator<Map.Entry<String, String>> iterator = entries.iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, String> next = iterator.next();
//            System.out.println(next.getKey()+"--"+next.getValue());
//        }
//        String name = testBean.getName();
//        System.out.println(name);
//        Computer computer = testBean.getComputer();
//        System.out.println(computer);
//        Map<String, Computer> map = testBean.getMap();
//        Set<Map.Entry<String, Computer>> entries = map.entrySet();
//        Iterator<Map.Entry<String, Computer>> iterator = entries.iterator();
//        while (iterator.hasNext()){
//            Map.Entry<String, Computer> next = iterator.next();
//            String key = next.getKey();
//            Computer value = next.getValue();
//            System.out.println(key+"--"+value);
//        }
//        StudentController controller = (StudentController) factory.getBean("studentController");
//        Student student = controller.selectOne();
//        System.out.println(student);

        TestProperties testProperties = (TestProperties) factory.getBean("testProperties");
        Properties properties = testProperties.getProperties();
        Enumeration<String> enumeration = (Enumeration<String>) properties.propertyNames();
        while (enumeration.hasMoreElements()){
            String key =  enumeration.nextElement();
            String value = (String) properties.get(key);
            System.out.println(key+"--"+value);
        }
    }
}
