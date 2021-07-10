package com.dpj.requestapi;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取请求的参数
        String name = req.getParameter("username");
        System.out.println("在Servlet1柜台1中查看参数："+name);
        //给材料盖一个章并传递到servlet2查看
        req.setAttribute("key1","servlet1的章");

        //2问servlet2怎么走
        /*
        * 请求转发必须要以/（斜杠）开始，斜杠表示地址为：http://ip:port/工程名/
        * 映射到idea代码的web目录
        * */
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");

        //走向servlet2
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
