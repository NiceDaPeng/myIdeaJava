package com.dpj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/nextController")
public class NextController {

    @RequestMapping("test1")
    public String testForward(){
        System.out.println("NextController.testForward");
        return "index";
    }



}
