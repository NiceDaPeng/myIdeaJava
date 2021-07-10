package controller;

import domain.Commodity;
import service.impl.CategoryService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class CheckoutPageController extends HttpServlet {
    private CategoryService service = MySpring.getBean("service.impl.CategoryService");
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        ArrayList<Commodity> commoList = (ArrayList<Commodity>)session.getAttribute("commoList");
        Float sum = 0f;
        for (Commodity commo :
                commoList) {
            Float commPrice = commo.getCommPrice();
            sum += commPrice;
        }
        req.setAttribute("sum",sum);
        req.getRequestDispatcher("checkoutPage.jsp").forward(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
