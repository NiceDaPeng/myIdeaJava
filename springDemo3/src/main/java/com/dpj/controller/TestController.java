package com.dpj.controller;


import com.dpj.vo.ParamVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Set;

@Controller
@RequestMapping("testController")
public class TestController {

    @RequestMapping("testParam1")
    public String test(String name,Integer age){
        System.out.println("name = " + name);
        System.out.println("age = " + age);
        return "index";
    }

    @RequestMapping("testParam2")
    public String testParam(String[] params){
        System.out.println("params = " + params[0]);
        System.out.println("params = " + params[1]);
        return "index";
    }

    @RequestMapping("testVO")
    public String testVO(ParamVO paramVO){
        System.out.println("paramVO = " + paramVO);
        return "index";
    }

    @RequestMapping("testMap")
    public String testMap(ParamVO paramVO){
        HashMap<String, String> map = paramVO.getMaps();
        Set<String> strings = map.keySet();
        for (String string : strings) {
            System.out.println(string+"map.get(string) = " + map.get(string));
        }
        return "index";
    }
}
