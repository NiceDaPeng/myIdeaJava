package controller;

import domain.Category;
import domain.Commodity;
import service.impl.CategoryService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class JudgeChangeController extends HttpServlet {

    private CategoryService service = MySpring.getBean("service.impl.CategoryService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //设置字符集
        req.setCharacterEncoding("UTF-8");
        //根据商品的id获取全部被选择的商品信息
        String[] commChecks = req.getParameterValues("commCheck");
        //为了能够在别的地方访问到购物车的信息，可以将选购的商品添加到集合中然后添加到 session对象里
        HttpSession session = req.getSession();
        //首先看session对象里面是否有这样的集合信息，如果没有则创建一个然后装入到session对象里面
        ArrayList<Commodity> commoList = (ArrayList<Commodity>) session.getAttribute("commoList");
        if (commoList == null){
            commoList = new ArrayList<Commodity>();
            //将集合放入到域对象session中
            session.setAttribute("commoList",commoList);
        }

        //将商品信息装入到集合中

        try {
            for (String value :
                    commChecks) {
                //调用业务层方法来查询商品的信息
                Commodity commodity = service.getCommodityByCommid(value);
                //将商品的信息添加到集合中
                commoList.add(commodity);
            }
        } catch (Exception e) {
            System.out.println("未选择商品");
        }finally {
            String hidden = req.getParameter("hidden");
            if (hidden.equals("继续购物")){
                req.getRequestDispatcher("categoryController").forward(req,resp);
            } else if (hidden.equals("商品结算")){
                req.getRequestDispatcher("checkoutPageController").forward(req,resp);
            }
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
