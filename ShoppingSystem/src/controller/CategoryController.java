package controller;

import domain.Category;
import domain.Commodity;
import service.impl.CategoryService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class CategoryController extends HttpServlet {

    //用来控制显示种类
    private CategoryService service = MySpring.getBean("service.impl.CategoryService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取页面传递来的参数
        //根据参数查询所有的商品信息存入到集合中
        //通过业务层去找到所有的种类
        List<Category> list = service.selectMore();
        //将集合内的信息设置为域数据，这样在浏览器就可以访问到
        req.setAttribute("category",list);
        //请求转发到购物界面。
        req.getRequestDispatcher("shopping.jsp").forward(req,resp);

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
