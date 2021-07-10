package controller;

import domain.Commodity;
import service.impl.CategoryService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SelectCommodityController extends HttpServlet {

    private CategoryService service = MySpring.getBean("service.impl.CategoryService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        //根据获取种类id
        String cateid = req.getParameter("cateid");
        //根据种类编号去获取对用种类的商品
        List<Commodity> commdityList = service.getMoreCommodityByCateid(cateid);
        //将所有对应种类的商品放到域数据中
        req.setAttribute("commdityList",commdityList);
        //转发给jsp做最终的响应拼接
        req.getRequestDispatcher("showCommodity.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
