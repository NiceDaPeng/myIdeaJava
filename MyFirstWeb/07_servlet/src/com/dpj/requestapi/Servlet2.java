package com.dpj.requestapi;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        System.out.println("在Servlet1柜台1中查看参数："+name);

        //查看是否有servlelt1的章
        Object key1 = req.getAttribute("key1");
        System.out.println("是否有servlet1的章"+key1);

        //处理自己的业务
        System.out.println("servlet2处理自己的业务");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
