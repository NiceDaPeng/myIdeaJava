package controller;

import com.alibaba.fastjson.JSONObject;
import domain.Student;
import service.StudentService;
import util.MyThreadLocal;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/login")
public class LoginController extends HttpServlet {

    private StudentService service = new StudentService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String saccount = request.getParameter("saccount");
        String spassword = request.getParameter("spassword");
        String result = service.login(saccount,spassword);
//        System.out.println(saccount);
//        System.out.println(spassword);
        System.out.println(result);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(result);
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
