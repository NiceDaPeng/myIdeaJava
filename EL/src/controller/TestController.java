package controller;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        User user = new User("张三","333");
        request.setAttribute("user",user);
        User[] userArray = new User[]{new User("lisi","444"),new User("wangwu","555")};
        request.setAttribute("userArray",userArray);
        request.getRequestDispatcher("good.jsp").forward(request,response);
    }
}
