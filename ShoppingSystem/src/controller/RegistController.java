package controller;

import service.impl.RegistService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.ResultSet;

public class RegistController extends HttpServlet {
    private RegistService service = new RegistService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean regist = service.regist(username, password);
        if (regist == true){
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        } else {
            req.setAttribute("errorMessage","账户已经存在");
            req.getRequestDispatcher("regist.jsp").forward(req,resp);
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
