package com.dpj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("testController")
public class TestController {

    @RequestMapping("test1")
    public String test1(String name,String password){
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "index";
    }
}
