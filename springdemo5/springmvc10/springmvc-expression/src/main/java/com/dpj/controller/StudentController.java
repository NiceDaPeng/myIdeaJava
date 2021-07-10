package com.dpj.controller;


import com.dpj.domain.Student;
import com.dpj.exception.MyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StudentController {


    @RequestMapping("testOne")
    @ResponseBody
    public Student testOne(){
        Student student = new Student("20","Linghuchong","Men",30);
        return student;
    }


    /**
     * 异常处理方法。
     * @return
     */
    @RequestMapping("testException")
    public String testException(){
        try {
            Student stu = null;
            stu.getSid();
        }catch (Exception e){
            throw new MyException("网页错误啦");
        }
        return "welcome.jsp";
    }


    @RequestMapping("testInterceptor")
    public String testInterceptor(){

        System.out.println("控制层执行了");
        return "welcome.jsp";
    }

}
