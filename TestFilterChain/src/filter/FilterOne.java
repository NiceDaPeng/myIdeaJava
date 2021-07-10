package filter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class FilterOne extends HttpFilter {

    @Override
    public void init() throws ServletException {
        System.out.println("Filter的init方法");
    }

    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("我是Filter，我执行了。");
        chain.doFilter(request,response);
    }
}
