package test;

import domain.Emp;
import domain.Student;
import domain.Teacher;
import service.EmpService;
import service.StudentService;
import service.TeacherService;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {

//        StudentService service = new StudentService();
////        Student student = service.selectOne(2);
////        System.out.println(student);
//        List<Student> students = service.selectAll();
//        for (Student stu :
//                students) {
//            System.out.println(stu);
//        }

//        TeacherService service = new TeacherService();
////        Teacher teacher = service.selectOne(1);
////        System.out.println(teacher);
//        List<Teacher> teachers = service.selectAll();
//        for (Teacher tea :
//                teachers) {
//            System.out.println(tea);
//        }

        EmpService service = new EmpService();
        List<Emp> empList = service.selectEmpByDeptnoAndJob("manager", 10);
        for (Emp emp :
                empList) {
            System.out.println(emp);
        }
    }
}
