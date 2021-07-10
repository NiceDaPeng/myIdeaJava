package controller;

import com.alibaba.fastjson.JSONObject;
import domain.Book;
import service.BookService;
import util.MySpring;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/showBooks")
public class ShowBooksController extends HttpServlet {

    private BookService service = MySpring.getBean("service.BookService");
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String saccount = request.getParameter("saccount");
        List<Book> bookList = service.selectAll();
        JSONObject json = new JSONObject();
        json.put("saccount",saccount);
        json.put("bookList",bookList);
        System.out.println(json.toJSONString());
        response.setCharacterEncoding("UTF-8");
        response.getWriter().write(json.toJSONString());
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
