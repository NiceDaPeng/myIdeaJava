package com.dpj.requestapi;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ServletTwo extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletConfig config = getServletConfig();
        String name = config.getInitParameter("name");
        String password = config.getInitParameter("password");
        System.out.println("初始化信息的账户是："+name);
        System.out.println("初始化信息的密码是："+password);
        String servletName = config.getServletName();
        System.out.println("请求的别名是："+servletName);
        ServletContext context = config.getServletContext();
        //context.setAttribute("key","good");
        String value1 = context.getInitParameter("key1");
        System.out.println("ServletContext的value是："+value1);
        String contextPath = context.getContextPath();
        System.out.println("当前的工程路径是："+contextPath);
        String realPath = context.getRealPath("/");
        System.out.println("当前工程再服务器上的绝对路径是："+realPath);

        String requestURI = req.getRequestURI();
        System.out.println("请求的资源是："+requestURI);

        StringBuffer requestURL = req.getRequestURL();
        System.out.println("请求的资源的统一资源定位符是："+requestURL);

        String remoteHost = req.getRemoteHost();
        System.out.println("发送请求的IP地址是："+remoteHost);

        String username = req.getParameter("username");
        System.out.println("传递的参数是："+username);

//        req.getRequestDispatcher("servletThree")//参数为要转发到哪个servlet程序。
        req.setAttribute("key1","servletTwo");
        //第一种方式：如下
//        resp.setCharacterEncoding("UTF-8");
//        resp.setHeader("content-Type","text/html;charset=UTF-8");

        //第二种方式如下：注意此方法一定是在获取流对象之前调用才有效
        resp.setContentType("text/html;UTF-8");
        PrintWriter writer = resp.getWriter();
        writer.append("UTF-8");
        writer.write("收到你发送来的请求了");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
