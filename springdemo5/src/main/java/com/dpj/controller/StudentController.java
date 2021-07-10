package com.dpj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.HashMap;

@Controller
public class StudentController {

//    private StudentService service;

    @RequestMapping(path="/test1",params = "method=get",method = RequestMethod.GET)
    public void test1(){
//        service.save(new Student());
//        service.findAll();
//        System.out.println("StudentController.test1---nice");
//        return "index";

        System.out.println("StudentController.test1");
    }

    @RequestMapping("/test2")
    public void test2(){
        System.out.println("StudentController.test2");
    }


    @RequestMapping("testParam1")
    public String testParam1(String name,String sex,Integer age){
        System.out.println("name = " + name);
        System.out.println("sex = " + sex);
        System.out.println("age =  " + age);

        return "welcome.jsp";
    }
}
