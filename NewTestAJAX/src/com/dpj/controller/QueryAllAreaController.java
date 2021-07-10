package com.dpj.controller;

import com.alibaba.fastjson.JSONObject;
import com.dpj.domain.Area;
import com.dpj.service.AreaService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/queryAllArea")
public class QueryAllAreaController extends HttpServlet {

    private AreaService service = new AreaService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //获取请求携带的参数
        String cid = request.getParameter("cid");
        //将参数交给service层处理，得到一个集合，集合里面是很多区域的编号和名字
        ArrayList<Area> areas = service.queryAreaByCid(cid);
        //创建一个JSON对象，JSON可以理解为一个容器
        JSONObject json = new JSONObject();
        //将集合添加到JSON对象中
        json.put("areas",areas);
        //设置响应信息的字符集
        response.setCharacterEncoding("UTF-8");
        //将JSON转为字符串直接响应给浏AJAX代码。
        response.getWriter().write(json.toJSONString());
    }
}
