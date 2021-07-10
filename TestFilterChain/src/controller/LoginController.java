package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("Servlet的init方法");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("我是真实的目标对象，取值，调用业务，转发等");
//
//        //服务器内部的请求转发和重定向会经过Filter吗？
////        request.getRequestDispatcher("welcome.jsp").forward(request,response);
//        response.sendRedirect("welcome.jsp");
        System.out.println("service方法");

    }
}
