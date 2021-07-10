package com.dpj.controller;


import com.dpj.domain.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
@RequestMapping("/paramController")
public class ParamController {

    @RequestMapping("/param1")
    public String test(String name,Integer age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "index";
    }

    @RequestMapping("/param2")
    public String param1(User user){
        System.out.println("user = " + user);
        System.out.println(user.getAge());
        return "index";
    }

    //参数传递 forward
    @RequestMapping("paramPassing")
    public String parameterPassing(HttpServletRequest request){
        String name="linghuchong";
        request.setAttribute("name",name);
        return "attr";
    }

    //参数传递redirect  传递的是个对象

    @RequestMapping("redirectParam")
    public String redirectParam(HttpServletRequest request, HttpServletResponse response){

        HttpSession session = request.getSession();
        User user = new User();
        user.setName("linghuchogn");
        user.setAge(30);
        session.setAttribute("user",user);
        return "redirect:../attr.jsp";
    }

    //forward  传递的是个对象
    @RequestMapping("forwardObj")
    public String forwardObj(HttpServletRequest request){
       User user = new User("linghuchong",30);
       request.setAttribute("user",user);
       return "attr";
    }

    //redirect 传递参数是个集合
    @RequestMapping("/redirectList")
    public String redirectList(HttpServletRequest request){
        HttpSession session = request.getSession();
        User user1 = new User("linghuchong",30);
        User user2 = new User("linghuchong",30);
        User user3 = new User("linghuchong",30);
        User user4 = new User("linghuchong",30);
        ArrayList<User> users = new ArrayList<>();
        session.setAttribute("users",users);
        return "redirect:/attr.jsp";
    }
}
