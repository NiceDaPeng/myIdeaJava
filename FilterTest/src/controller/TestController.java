package controller;

import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class TestController extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String result = service.login(username);
        if (result.equals("登录成功")){
            HttpSession session = request.getSession();
            session.setAttribute("username",username);
            session.setMaxInactiveInterval(8);
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
            System.out.println(result);
        } else {
            request.setAttribute("result",result);
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }

    }
}
