package controller;

import service.impl.UserService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class UserController extends HttpServlet {
    private UserService service = MySpring.getBean("service.impl.UserService");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理字符集的问题
        request.setCharacterEncoding("UTF-8");
        //获取登录页面传递过来的账号和密码
        String uname = request.getParameter("uname");
        String upassword = request.getParameter("upassword");
        //通过业务层去处理账号密码是否正确
        boolean login = service.login(uname, upassword);

        //如果正确
        if (login == true){
            //将姓名存入到session对象中，这样我们在别的请求中使用的时候就可以用了
            HttpSession session = request.getSession();
            session.setAttribute("uname",uname);
//            System.out.println("登录成功");
            request.getRequestDispatcher("welcome.jsp").forward(request,response);
        } else {
            //登录失败的情况下，给一次请求的域对象设置一个数据，方便在登录界面上显示。
            HttpSession session = request.getSession();
            request.setAttribute("errorMessage","登录失败");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
