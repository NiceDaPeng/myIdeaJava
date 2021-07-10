package controller;

import server.HttpServlet;
import server.HttpServletRequest;
import server.HttpServletResponse;

public class IndexController extends HttpServlet {

    @Override
    public void service(HttpServletRequest request, HttpServletResponse response) {
        response.sendRedirect("index.view");
    }
}
