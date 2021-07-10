package com.dpj.servlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet4 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext = getServletConfig().getServletContext();
        String username = servletContext.getInitParameter("username");
        String password = servletContext.getInitParameter("password");
        System.out.println("获取到的ServletContext对象的值是："+username);
        System.out.println("获取到的ServletContext对象的值是："+password);

//        2，获取当前的工程路径，格式：/工程路径
        String contextPath = servletContext.getContextPath();
        System.out.println("当前工程路径是："+contextPath);
//        3，获取工程部署后在服务器硬盘上的绝对路径
        /**
         * /  斜杠表示的是 被服务器解析的地址：http://ip:port/工程名/
         */
        String realPath = servletContext.getRealPath("/");
        System.out.println("工程部署的绝对路径是:"+realPath);
        System.out.println(servletContext.getRealPath("/css"));
        System.out.println(servletContext.getRealPath("/imgs/mysql.jpg"));
//        4，象Map一样存储数据
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
