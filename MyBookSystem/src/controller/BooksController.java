package controller;

import domain.Books;
import service.impl.BooksService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class BooksController extends HttpServlet {

    private BooksService service = new BooksService();
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Books> allBooks = service.getAllBooks();
        HttpSession session = request.getSession();
        session.setAttribute("booksList",allBooks);
        request.getRequestDispatcher("pages/welcome.jsp").forward(request,response);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
