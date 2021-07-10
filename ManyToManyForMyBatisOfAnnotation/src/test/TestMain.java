package test;

import domain.Emp;
import domain.Student;
import service.EmpService;
import service.StudentService;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {
//        StudentService service = new StudentService();
//        Student student = service.selectOne(1);
//        System.out.println(student);
//
//        System.out.println("===============以上为单条查询=========================");
//        List<Student> students = service.selectAll();
//        for (Student stu :
//                students) {
//            System.out.println(stu);
//        }
//        List<Student> students = service.selectStudentByDynamic(1, null);
//        for (Student stu :
//                students) {
//            System.out.println(stu);
//        }

        EmpService service = new EmpService();
//        List<Emp> empList = service1.selectByDeptnoAndJob(10, "manager");
//        for (Emp emp :
//                empList) {
//            System.out.println(emp);
//        }
//        List<Emp> empList = service.selectByDeptnoAndJob(null, null);
//        for (Emp emp :
//                empList){
//
//            System.out.println(emp);
//        }

        List<Emp> empList = service.selectEmpByEmpno(7069, 7369);
        for (Emp emp :
                empList) {
            System.out.println(emp);
        }
    }
}
