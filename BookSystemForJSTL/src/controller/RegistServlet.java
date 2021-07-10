package controller;

import domain.User;
import service.UserService;
import service.impl.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class RegistServlet extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        req.setCharacterEncoding("UTF-8");
//        resp.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String repwd = req.getParameter("repwd");
        String email = req.getParameter("email");
        String code = req.getParameter("code");

        UserService service = new UserServiceImpl();
        boolean existsUser = service.existsUser(username);
        if (existsUser == true){
            RequestDispatcher requestDispatcher = req.getRequestDispatcher("/pages/user/regist.html");
            requestDispatcher.forward(req,resp);
//            System.out.println(" 用户名已经存在");
        } else if ("abcde".equalsIgnoreCase(code)){
//            resp.setContentType("text/html;charset=utf-8");
            service.registUser(new User(null,username,password,email));
            req.getRequestDispatcher("/pages/user/regist_success.html").forward(req,resp);
//            System.out.println("注册成功，请登录");
        }
    }
}

