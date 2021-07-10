package controller;

import Service.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginController extends HttpServlet {

    private UserService service = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String result = service.login(username, password);

        if (result.equals("登录成功")){
            Cookie cookie = new Cookie("username",username);
            Cookie cookie1 = new Cookie("password",password);
            cookie.setMaxAge(10);
            cookie1.setMaxAge(10);
            response.addCookie(cookie);
            response.addCookie(cookie1);
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
