package com.dpj.servlet;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class HelloServlet implements Servlet {
    public HelloServlet() {
        System.out.println("构造器方法");
    }

    @Override
    public void init(ServletConfig servletConfig) throws ServletException {
        System.out.println("init方法执行了");
//        1，可以获取Servlet程序的别名 Servlet-name的值
        String servletName = servletConfig.getServletName();
//        2，获取初始化参数init-param
        String username = servletConfig.getInitParameter("name");
        String url = servletConfig.getInitParameter("url");
        System.out.println("用户名是："+username);
        System.out.println("url是："+url);
//        3，获取ServletContext对象
        System.out.println(servletConfig.getServletContext());
    }

    @Override
    public ServletConfig getServletConfig() {
        return null;
    }
//    service方法是专门用来处理请求和响应的。
    @Override
    public void service(ServletRequest servletRequest, ServletResponse servletResponse) throws ServletException, IOException {
        System.out.println("service方法执行了");
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        String method = httpServletRequest.getMethod();
        /**
         * 通过在service方法中获取请求的方式，然后做判断
         * 从而调用不同的功能方法
         */
        if ("GET".equals(method)){
            this.doGet();
        } else if ("POST".equals(method)){
            this.doPost();
        }
    }

    //Get请求要做很多事情，如果全部放在service方法中，那么service方法就显得很臃肿，

    /**
     * 开发的时候，一个方法尽量只做一件事情，所以可以将get请求要做的事情，和post要做的事情分离开
     */
    public void doGet(){
        System.out.println("service的get提交方式");
        System.out.println("service的get提交方式");
    }

    //做post请求的操作
    public void doPost(){
        System.out.println("service的post提交方式");
        System.out.println("service的post提交方式");
    }
    @Override
    public String getServletInfo() {
        return null;
    }

    @Override
    public void destroy() {
        System.out.println("destroy销毁方法");
    }
}
