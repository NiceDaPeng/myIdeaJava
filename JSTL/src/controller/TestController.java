package controller;

import domain.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;

public class TestController extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Date date = new Date();
        request.setAttribute("date",date);
        String strValue="abcdefg";
        request.setAttribute("strValue",strValue);
        request.setAttribute("value",20);
        User user = new User("zhangsan","333");
        User user1 = new User("lisi","444");
        User user2 = new User("wangwu","555");
//        request.setAttribute("user",user);
        ArrayList<User> userList = new ArrayList<>();
        userList.add(user);
        userList.add(user1);
        userList.add(user2);
        request.setAttribute("userList",userList);
        request.getRequestDispatcher("show.jsp").forward(request,response);

    }
}
