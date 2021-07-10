package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class TestFilter extends HttpFilter {

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        String requestURI = request.getRequestURI();
        //如果是第一次请求（打开浏览器发送登录或者是首页的网址），直接放行，
        if ( requestURI.contains("index") || requestURI.contains("login") || username != null){
            chain.doFilter(request,response);
        } else {

            request.setAttribute("result","登录超时请重新登录");
            request.getRequestDispatcher("index.jsp").forward(request,response);
        }
    }
}
