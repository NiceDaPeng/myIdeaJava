package controller;

import com.alibaba.fastjson.JSONObject;
import service.UserService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registExists")
public class RegistExistsController extends HttpServlet {
    private UserService service = new UserService();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String uname = req.getParameter("username");
        String existsUname = service.existsUname(uname);

        if ("账户已存在".equals(existsUname)){
            JSONObject json = new JSONObject();
            json.put("message","账户已经存在");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json.toJSONString());
        } else {
            JSONObject json = new JSONObject();
            json.put("message","账户可用");
            resp.setCharacterEncoding("UTF-8");
            resp.getWriter().write(json.toJSONString());
        }
    }
}
