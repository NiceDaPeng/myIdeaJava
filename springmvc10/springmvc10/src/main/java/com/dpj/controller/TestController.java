package com.dpj.controller;


import com.dpj.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class TestController {


    //响应数据为json格式
    @RequestMapping("testResponse")
    @ResponseBody
    public User testResponse(){
        return new User("linghuchong","aaa");
    }
}
