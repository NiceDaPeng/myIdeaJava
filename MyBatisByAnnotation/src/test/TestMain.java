package test;

import domain.*;
import service.*;

import java.util.List;

public class TestMain {

    public static void main(String[] args) {

//        StudentService service  = new StudentService();
//        service.delete(8);

//        Student student = new Student();
//        student.setSid(8);
//        student.setSname("王一一");
//        student.setSsex("女");
//        student.setSage(20);
//        service.update(student);
//        Student student = service.selectOne(5);
//        System.out.println(student);

//        List<Student> students = service.selectAll();
//        for (Student stu :
//                students) {
//            System.out.println(stu);
//        }

//        PersonService service = new PersonService();
////        Person person = service.selectOne(1);
////System.out.println(person);
//        List<Person> personList = service.selectAll();
//        for (Person p :
//                personList) {
//            System.out.println(p);
//        }

//        IDCardService service = new IDCardService();
////        IDCard idCard = service.selectOne("20210604");
////
//// System.out.println(idCard);
//        List<IDCard> idCards = service.selectAll();
//        for (IDCard card :
//                idCards) {
//            System.out.println(card);
//        }

//        EmpService service = new EmpService();
//        Emp emp = service.selectOne(7069);
//        System.out.println(emp);


//        EmpService service = new EmpService();
//        List<Emp> empList = service.selectAll();
//        for (Emp e :
//                empList) {
//            System.out.println(e);
//        }

        DeptService service = new DeptService();
//        Dept dept = service.selectDept(10);
//        System.out.println(dept);

        List<Dept> depts = service.selectAll();
        for (Dept d :
               depts ) {
            System.out.println(d);
        }

    }
}
