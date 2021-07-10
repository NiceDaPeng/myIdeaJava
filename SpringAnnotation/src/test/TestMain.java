package test;

import controller.StudentController;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;
import java.util.Map;

public class TestMain {
    public static void main(String[] args) {

        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        StudentController controller = (StudentController) factory.getBean("studentController");
        List<Map<String, Object>> stuList = controller.select("男");
        System.out.println(stuList);

    }
}
