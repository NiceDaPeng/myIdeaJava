package com.dpj.controller;

import com.alibaba.fastjson.JSONObject;
import com.dpj.domain.City;
import com.dpj.service.CityService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet("/queryCity")
public class QueryCityController extends HttpServlet {

    private CityService service = new CityService();

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String aid = request.getParameter("aid");
        ArrayList<City> cities = service.queryCityByAid(aid);
        System.out.println(cities);
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("cities", cities);
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(jsonObject.toJSONString());
    }
}
