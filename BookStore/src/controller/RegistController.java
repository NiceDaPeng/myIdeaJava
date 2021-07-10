package controller;

import com.alibaba.fastjson.JSONObject;
import domain.User;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registController")
public class RegistController extends HttpServlet {

    private UserService service = new UserService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("我执行了！");
        String uname = request.getParameter("username");
        String upassword = request.getParameter("password");
        String uemail = request.getParameter("email");
        User user = new User();
        user.setUname(uname);
        user.setUpassword(upassword);
        user.setUemail(uemail);
        String registResult = service.regist(user);
        if ("注册成功".equals(registResult)){
            request.setAttribute("uname",uname);
            request.getRequestDispatcher("/pages/user/regist_success.html").forward(request,response);
        } else {
            JSONObject json =new JSONObject();
            json.put("user",user);
            request.setAttribute("errorMessage","用户名已存在");
            request.getRequestDispatcher("/pages/user/regist.html");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
