package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class Servlet2 extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        System.out.println("在servlet1中查看参数"+username);
        Object key1 = req.getAttribute("key1");
        System.out.println("servlet1是否有完成操作"+key1);

        //处理自己的业务
        System.out.println("处理自己的业务");

    }
}
