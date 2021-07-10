package com.dpj.controller;


import com.dpj.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {


    @RequestMapping("testOne")
    @ResponseBody
    public User testOne(){
        return new User("linghuchong","aaa");
    }


    @RequestMapping("testTwo")
    @ResponseBody
    public User testTwo(@RequestBody User user){
        System.out.println("user.getName() = " + user.getName());
        System.out.println("user.getPassword() = " + user.getPassword());
        return user;
    }

}
