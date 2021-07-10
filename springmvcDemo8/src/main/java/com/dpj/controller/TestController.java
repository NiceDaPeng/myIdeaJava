package com.dpj.controller;

import com.dpj.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {

    //今天学习的内容是
    /**
     * 返回的是对象类型或者是map类型的，在前台接收
     */

    @RequestMapping("testOne")
    @ResponseBody
    public User testOne(){

        User user1 = new User("linghuchong","aaa");

        return user1;
    }

    //如果发过来的信息是json形式的如何接收

    @RequestMapping("testTwo")
    @ResponseBody
    public User testTwo(@RequestBody User user){

        System.out.println("user.getName() = " + user.getName());
        System.out.println("user.getPassword() = " + user.getPassword());
        return user;
    }
}
