package com.dpj.requestapi;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Arrays;

public class ServletOne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取请求的参数
        String username = request.getParameter("username");
        String pwd = request.getParameter("password");
//        String hobby  = request.getParameter("hobby");
        //多个值的时候用getParameterValues（）
        String[] hobby = request.getParameterValues("hobby");

        System.out.println("账号："+username);
        System.out.println("密码："+pwd);
        System.out.println("爱好："+ Arrays.asList(hobby));
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");//这一行代码必须要写在我们获取请求参数之前。
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String[] hobbies = request.getParameterValues("hobby");
        System.out.println("账号："+username);
        System.out.println("密码："+password);
        System.out.println("爱好："+ Arrays.asList(hobbies));

    }
}
