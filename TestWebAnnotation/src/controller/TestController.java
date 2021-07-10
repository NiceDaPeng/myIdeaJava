package controller;

import annotation.MyAnnotation;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebServlet(
        value = "/test",
        loadOnStartup = 0,
        description = "相当于注释，告诉你们我这个类干嘛用的",
        displayName = "用来显示当前请求的名字",
        asyncSupported = true,//是否支持异步操作，
        //urlPatterns = "/test", //等价于values，
        initParams = {
        @WebInitParam(name = "key",value = "value"),
        @WebInitParam(name = "key1",value = "value1"),
        @WebInitParam(name = "key2",value = "value2")
})
public class TestController extends HttpServlet {

    @Override
    public void init() throws ServletException {
        ServletConfig config = getServletConfig();
        Enumeration<String> init = config.getInitParameterNames();
        while (init.hasMoreElements()){
            String key = init.nextElement();
            String value = config.getInitParameter(key);
            System.out.println(key+"--"+value);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
