package controller;

import service.AtmService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class TransferController extends HttpServlet {
    private AtmService service = MySpring.getBean("service.AtmService");
    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String aname = (String) request.getSession().getAttribute("aname");
        String otherName = request.getParameter("otherName");
        String transferMoney = request.getParameter("transferMoney");

        boolean temp = service.transferMoney(aname, Float.parseFloat(transferMoney), otherName);
        if (temp == false){
            request.setAttribute("errorMessage","转入失败");
            request.getRequestDispatcher("login.jsp").forward(request,response);
        } else {
            request.getRequestDispatcher("login.jsp").forward(request,response);
        }
    }
}
