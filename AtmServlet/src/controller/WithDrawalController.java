package controller;

import service.AtmService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class WithDrawalController extends HttpServlet {
    private AtmService service = MySpring.getBean("service.AtmService");
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String aname = (String) request.getSession().getAttribute("aname");
        String outMoney = request.getParameter("outMoney");
        boolean temp = service.outMoney(aname, Float.parseFloat(outMoney));
        if (temp == false){
            request.getRequestDispatcher("withDriawal.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }

    }
}
