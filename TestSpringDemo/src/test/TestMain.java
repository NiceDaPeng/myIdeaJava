package test;

import domain.Room;
import domain.Student;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

    public static void main(String[] args) {
//        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml","ApplicationContext_Dao.xml","ApplicationContext_Service.xml","ApplicationContext_Service.xml");
//        BeanFactory factory1 = new ClassPathXmlApplicationContext(new String[]{"ApplicationContext.xml","ApplicationContext_Dao.xml","ApplicationContext_Service.xml","ApplicationContext_Service.xml"});
//        BeanFactory factory2 = new ClassPathXmlApplicationContext("ApplicationContext*.xml");
//        Student stu = (Student) factory.getBean("student");
//        Student stu1 = (Student) factory.getBean("student");
//        System.out.println(stu);
//        System.out.println(stu1);
//        Student student = (Student) factory.getBean("student");
//        StudentService service = (StudentService) factory.getBean("studentService");
//        StudentDao studentDao = (StudentDao) factory.getBean("studentDao");
//        StudentController controller = (StudentController) factory.getBean("studentController");
//        System.out.println(service);
////        System.out.println(studentDao);
//        System.out.println(controller);
        //===========================================================================
//        Student student = (Student) factory.getBean("student");
//        System.out.println(student);
        BeanFactory factory = new ClassPathXmlApplicationContext("ApplicationContext.xml");
        Room room = (Room) factory.getBean("room");
        System.out.println(room);


    }
}
