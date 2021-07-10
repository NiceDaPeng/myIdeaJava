package com.dpj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/hello")
public class HelloController {

    /**
     * @RequestMapping注解可以用在类上也可以用在方法上
     * 用在方法上：是给当前方法加入指定的请求路径
     * 当你发送这个请求的时候，就会访问到这 个方法。
     *
     * 用在类上：用来给类中的所有方法加入统一的请求路径，在访问方法之前需要加入类上的@RequestMapping（“路径”）
     *
     * 一旦类上和方法上同时加上了@RequestMapping，
     * 访问时，如果还想要访问方法上的RequestMapping路径，那么就必须如下：
     * 必须/项目名/类上的@RequestMapping/方法上的@RequestMapping的路径
     * http://localhost:8080/springmvc_demo1/hello/hello
     */
    @RequestMapping(value = "hello")
    public String hello(){
        //收集数据
        //调用业务
        System.out.println("hello spring mvc");
        //处理响应
        return "index";//页面逻辑名
    }

//    springmvc的跳转方式 controller通过redirec重定向，跳转到index.jsp
    @RequestMapping("test1")
    public String test1(){
        System.out.println("HelloController.test1");
        return "redirect:/index.jsp";
    }


    //通过forward实现在同一控制层间跳转不同方法
    @RequestMapping("test2")
    public String test2(){
        System.out.println("HelloController.test2");
        return "forward:/hello/test1";
    }

    //通过redirect实现在同一控制层跳转不同方法
    @RequestMapping("test3")
    public String test3(){
        System.out.println("HelloController.test3");
        return "redirect:/hello/hello";
    }


    //测试跳转到另外一个controller
    @RequestMapping("test4")
    public String test4(){
        System.out.println("HelloController.test4");
        return "forward:/nextController/test1";
    }

    //测试redirect跳转到另外一个controller
    @RequestMapping("test5")
    public String test5(){
        System.out.println("HelloController.test5");
        return "redirect:/nextController/test1";
    }
}
