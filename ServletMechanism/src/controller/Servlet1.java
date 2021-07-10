package controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet1 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
//        resp.setContentType("text/html;charset=UTF-8");
        //获取请求参数
        String username = req.getParameter("username");
        //在servlet1中查看参数
        System.out.println("在servlet1中查看参数"+username);
        //设置域数据
        req.setAttribute("key1","value1");
        //请求调度到/servlet2资源
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/servlet2");
        //调度器开始运作
        requestDispatcher.forward(req,resp);
        //sout
        System.out.println("开始向servlet2转发");
    }
}
