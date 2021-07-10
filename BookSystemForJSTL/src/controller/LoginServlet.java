package controller;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

public class LoginServlet extends HttpServlet {

    private UserService service = new UserServiceImpl();

    public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        try {
            request.setCharacterEncoding("UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        User user = service.login(new User(null, username, password, null));
        if (user != null){
            request.getRequestDispatcher("/pages/user/login_success.html").forward(request,response);
            System.out.println("登录成功");

        } else {
            request.getRequestDispatcher("/pages/user/login.html").forward(request,response);
            System.out.println("用户名或密码错误");
        }
    }
}
