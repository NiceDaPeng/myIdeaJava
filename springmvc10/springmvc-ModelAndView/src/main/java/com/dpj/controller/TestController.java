package com.dpj.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.Servlet;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
@SessionAttributes("username")
public class TestController {

    @RequestMapping("testOne")
    public ModelAndView testOne(HttpServletResponse response){
        ModelAndView md = new ModelAndView();
        md.addObject("username","linghuchong");
        md.setViewName("welcome.jsp");
        return md;
    }

    public String testTwo(HttpServletRequest request,HttpServletResponse response){

        HttpSession session = request.getSession();
        session.setAttribute("count",new Integer(10));
        return "";
    }
}
