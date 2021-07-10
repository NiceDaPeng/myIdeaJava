package controller;

import com.alibaba.druid.sql.dialect.mysql.ast.statement.MySqlPartitionByKey;
import service.AtmService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class DoDespotController extends HttpServlet {
    private AtmService service = MySpring.getBean("service.AtmService");
    @Override
    public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        String inMoney = req.getParameter("inMoney");
        String aname = (String) req.getSession().getAttribute("aname");
//        String aname = req.getParameter("aname");
        System.out.println(inMoney+""+aname);
        service.saveMoney(aname,Float.parseFloat(inMoney));
        req.getRequestDispatcher("login.jsp").forward(req,res);
    }
}
