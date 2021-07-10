package controller;

import service.AtmService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class QueryController extends HttpServlet {
    private AtmService atmService = MySpring.getBean("service.AtmService");
    public void service(HttpServletRequest request, HttpServletResponse response)throws ServletException,IOException{
        HttpSession session = request.getSession();
        String aname = (String) session.getAttribute("aname");
        Float abalance = atmService.selectBalance(aname);
        //abalance是控制层找寻底层的业务得来的结果，这个结果请求的时候是不知道的。
        // 但是后面的jsp想要。所以这个ablance要带走给到后面的jsp使用
        //request对象中有两个Map集合
        // Map<String,String>   request.getParameter("")  一个集合是用来存储请求发送来的信息的
        // ,Map<String,Object>  这个需要先存起来，然后再用的时候通过request.getAttribute();来获取 ，一个集合是用来存储我们在控制层得到的值的。
        //
        request.setAttribute("abalance",abalance);//底层还是一个Map集合
        request.getRequestDispatcher("queryBalance.jsp").forward(request,response);
    }
}
