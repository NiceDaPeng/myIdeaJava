package controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这是一个控制层的类
 * 这个类最早用tomcat管理的时候是有一些规则的
 * 原来                                   SpringMVC
 * 继承                                   实现Controller
 * 重写                                   重写handleRequest方法
 * 参数                                   request，response
 * 返回值                                  ModelAndView
 * 异常                                   Exception
 * 请求和真实资源的对应关系
 *
 */
@RequestMapping
public class TestController implements Controller {

    @Override
    public ModelAndView handleRequest(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws Exception {
        System.out.println("我是控制层，我执行了");
        return null;
    }
}
