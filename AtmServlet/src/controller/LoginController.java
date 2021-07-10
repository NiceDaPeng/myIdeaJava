package controller;

import service.AtmService;
import util.MySpring;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginController extends HttpServlet {
    private AtmService service = MySpring.getBean("service.AtmService");
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //设置request的拆分字符集
        request.setCharacterEncoding("UTF-8");
        //首先获取参数信息
        String aname = request.getParameter("aname");
        String apassword = request.getParameter("apassword");
//        System.out.println("姓名"+aname+"密码："+apassword);
        //将参数发送给业务层去判断是否正确

        boolean login = service.login(aname, apassword);
//        System.out.println("判断后的结果为："+login);
        response.setCharacterEncoding("UTF-8");//设置服务器向浏览器发送响应信息的字符集
        if (login == true){
            //登录成功了，将请求转发到jsp文件  将jsp文件响应给浏览器
            HttpSession session = request.getSession();
            session.setAttribute("aname",aname);
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            //登录失败
            request.getRequestDispatcher("login.html").forward(request,response);
        }
    }
}
