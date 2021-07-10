package controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我是TestController");
        String username = req.getParameter("username");
        req.setAttribute("test",username);
        req.setAttribute("test","good");
        req.removeAttribute("test");

        HttpSession session = req.getSession();
        session.setAttribute("test",username);
        session.setAttribute("test","hahaha");
        session.removeAttribute("test");
    }
}
