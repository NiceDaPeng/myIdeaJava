package controller;

import service.AtmService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;

public class DoWithDrawalController extends HttpServlet {

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {

        String aname = req.getParameter("aname");
        String outMoney = req.getParameter("outMoney");

        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");

        AtmService service = MySpring.getBean("service.AtmService");
        service.outMoney(aname,new Float(outMoney));
        PrintWriter out = res.getWriter();
        out.write("<html>");
        out.write("<head>");
        out.write(" <meta charset=\"UTF-8\"/>");//告诉浏览器按照字符集解析
        out.write("</head>");
        out.write("<body>");
        out.write("********************************<br>");

        out.write("欢迎登录ATM系统:" + aname + "<br>");
        out.write("********************************* <br>");
        out.write("请选择操作项：<br>");
        out.write("<a href='query?aname=" + aname + "'>查询</a> <br>");
        out.write("<a href='despot?aname=" + aname + "'>存款</a> <br>");
        out.write("<a href='withDrawal?aname=" + aname + " '>取款</a> <br>");
        out.write("<a href='transfer?aname=" + aname + " '>转账</a> <br>");
        out.write("</body>");
        out.write("</html>");
        out.flush();//要清空一下流管道

    }
}
