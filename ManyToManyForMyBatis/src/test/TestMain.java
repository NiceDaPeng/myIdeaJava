package test;

import domain.Student;
import domain.Teacher;
import service.StudentService;
import service.TeacherService;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {

//        TeacherService service = new TeacherService();
//        Teacher teacher = service.selectOne(1);
//        System.out.println(teacher);

//        StudentService service = new StudentService();
//        Student student = service.selectOne(3);
//        System.out.println(student);

        StudentService service = new StudentService();
        List<Student> students = service.selectAll();
        for (Student s :
                students) {
            System.out.println(s);
        }
    }
}
