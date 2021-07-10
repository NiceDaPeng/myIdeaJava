package com.dpj.controller;

import com.alibaba.fastjson.JSONObject;
import com.dpj.domain.Country;
import com.dpj.service.CountryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/queryAllCountry")
public class QueryAllCountryController extends HttpServlet {

    private CountryService service = new CountryService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ArrayList<Country> countries = service.queryAllCountry();
        request.setAttribute("countries",countries);
        request.getRequestDispatcher("regist.jsp").forward(request,response);
//        JSONObject json = new JSONObject();
//        json.put("countries",countries);
//        response.setCharacterEncoding("UTF-8");
//        response.getWriter().write(json.toJSONString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
