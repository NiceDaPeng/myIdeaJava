package com.dpj.requestapi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HttpServletRequestAPI extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //    getRequestURI（）获取请求的资源路径
        System.out.println("URI>="+req.getRequestURI());
//    getRequestURL（）获取请求的统一资源定位符（绝对路径）
        System.out.println("URL>="+req.getRequestURL());
//    getRemoteHost（）获取客户端的IP地址
        /*
        * 在idea中，使用localHost访问时，得到的客户端的IP地址是127.0.0.1
        * 在idea中，使用127.0.0.1访问时，得到的客户端的IP地址是127.0.0.1
        * 在idea中，使用真实IP地址访问时，得到的客户端的IP地址是真实的客户端IP地址。
        * */
        System.out.println("IP>="+req.getRemoteHost());
//    getHeader（）	获取请求头
        System.out.println("请求头：user-agent"+req.getHeader("user-agent"));
//    getParameter（）获取请求的参数

//    getParameterValues()获取请求的参数（多个值的时候使用）

//    getMethod() ：获取请求的方式
//    setAttribute(key,value)   设置域数据

//    getAttributeValue(key);获取域数据

//    getRequestDispatcher();获取请求转发对象。
    }

}
