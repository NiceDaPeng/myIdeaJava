package test;

import domain.Student;
import service.StudentService;

import java.sql.Date;
import java.util.List;


public class TestMain {

    public static void main(String[] args) {

        StudentService service = new StudentService();
//        Student student = new Student(16,"令狐冲",1,"男",new Date(System.currentTimeMillis()));
//        service.regist(student);

//        service.update(new Student(9,"洪七公",2,"女",new Date(System.currentTimeMillis())));
//        service.delete(9);
//        Student student = service.selecOne(1);
//        System.out.println(student);
        List<Student> stuList = service.selectAllByOrder("desc");
        for (Student stu :
                stuList) {
            System.out.println(stu);
        }


    }

}
