package controller;

import domain.User;
import service.UserService;
import util.ThreadLocalManager;

import javax.servlet.ServletException;
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
            ThreadLocal local = ThreadLocalManager.getLocal(username);
            User user = (User) local.get();
            request.setAttribute("user",user);
            request.getRequestDispatcher("welcome.jsp").forward(request,response);

        } else {
            request.setAttribute("error","账号或密码错误");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
