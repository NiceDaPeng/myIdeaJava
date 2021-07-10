package com.dpj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class TestController {


    //设计一个方法用来表示请求的资源--Controller类

    @RequestMapping("test")
    public String test(String name, String password, HttpServletRequest request){
        System.out.println("TestController.test");
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        request.setAttribute("name",name);
        return "redirect:welcome.jsp";//这个返回值，是一个逻辑名，
    }


    @RequestMapping("testRedirect")
    public String test1(String name,String password){
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "welcome";
    }
}
