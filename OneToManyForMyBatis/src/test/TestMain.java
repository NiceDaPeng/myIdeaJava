package test;

import domain.Dept;
import domain.Emp;
import service.DeptService;
import service.EmpService;

import java.util.List;

public class TestMain {


    public static void main(String[] args) {

//        EmpService service = new EmpService();
////        Emp emp = service.selectOne(7369);
////        System.out.println(emp);
//        List<Emp> emps = service.selectAll();
//        for (Emp emp :
//                emps) {
//            System.out.println(emp.getEname()+"--"+emp.getSal()+"--"+emp.getDept().getDeptno());
//        }

        DeptService service = new DeptService();
        Dept dept = service.selectOne(20);
        System.out.println(dept);

//        List<Dept> depts = service.selectAll();
//        for (Dept d :
//                depts) {
//            System.out.println(d);
//        }
    }
}
