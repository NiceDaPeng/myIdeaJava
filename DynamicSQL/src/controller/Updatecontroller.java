package controller;

import service.EmpService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/updateEmp")
public class Updatecontroller extends HttpServlet {

    private EmpService service = new EmpService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String[] empnos = request.getParameterValues("empno");
        System.out.println("测试下controller是否运行了");
        service.updateEmp(empnos);
        request.getRequestDispatcher("update.html").forward(request,response);
    }
}
