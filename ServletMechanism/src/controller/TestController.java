package controller;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

public class TestController extends HttpServlet {

    @Override
    public void destroy() {
        System.out.println("Servlet对象正在销毁");
    }

    public void init() {
        System.out.println("Servlet对象已经创建成功");
    }

    public void init(ServletConfig config) {
        Enumeration<String> en = config.getInitParameterNames();
        while (en.hasMoreElements()) {
            String key = en.nextElement();
            String value = config.getInitParameter(key);
            System.out.println(key + "--" + value);
        }
    }

    @Override
    public void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
    }
}
