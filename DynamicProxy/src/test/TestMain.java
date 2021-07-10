package test;

import domain.Student;
import service.StudentService;

import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {

        StudentService service = new StudentService();
        //接收请求发来的参数
        Scanner input = new Scanner(System.in);
        System.out.println("请输入注册信息");
        System.out.println("sid");
        String sid = input.nextLine();
        System.out.println("sname");
        String sname = input.nextLine();
        System.out.println("ssex");
        String ssex = input.nextLine();
        System.out.println("sage");
        String sage = input.nextLine();
        //将参数信息封装成一个VO对象
        Student student = new Student(Integer.parseInt(sid),sname,ssex,Integer.parseInt(sage));
        service.insertStudent(student);
    }
}
