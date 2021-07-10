package com.dpj.controller;


import com.dpj.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
public class TestController {


    @RequestMapping("test1")
    public String test1(String name,String password){
        System.out.println("name = " + name);
        System.out.println("password = " + password);
        return "";
    }

    @RequestMapping("test2")
    public String test2(User user){
        System.out.println("user = " + user);
        System.out.println("user.getUname() = " + user.getUname());
        return "";
    }

    @ResponseBody
    @RequestMapping("test3")
    public Map test3(@RequestBody User user){
        User user0 = new User();
        user.setUname("dpj");
        user.setUpassword("aaa");
        User user1 = new User("linghuchong","bbb");
        User user2 = new User("renyingying","bbb");
        User user3 = new User("dongfangbubai","bbb");
        Map users = new HashMap();
        users.put("user1",user1);
        users.put("user2",user2);
        users.put("user3",user3);
        return users;
    }


    @RequestMapping("test4")
    @ResponseBody
    public Map test4(@RequestBody User user){
        
        return new HashMap();
    }

}
