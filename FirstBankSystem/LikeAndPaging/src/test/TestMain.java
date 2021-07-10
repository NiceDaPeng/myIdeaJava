package test;

import domain.Emp;
import service.EmpService;

import java.util.ArrayList;

public class TestMain {

    public static void main(String[] args) {

        EmpService es = new EmpService();
        ArrayList<Emp> list = es.changePageToRowIndex(3);
        for (Emp emp :
                list) {
            System.out.println(emp);
        }
    }
}
