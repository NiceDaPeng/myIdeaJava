package filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;

@WebFilter(
        urlPatterns = {"/*"},
        description = "描述",
        initParams = {
                @WebInitParam(name = "haha",value = "good"),
                @WebInitParam(name = "wawawa",value = "well")
        }

) //表示链接所有的请求
public class TestFilter extends HttpFilter {

    @Override
    public void init(FilterConfig config) throws ServletException {
        Enumeration<String> initEnum = config.getInitParameterNames();
        while (initEnum.hasMoreElements()){
            String key = initEnum.nextElement();
            String value = config.getInitParameter(key);
            System.out.println(key+"--"+value);
        }
        System.out.println("我是filter的init，我加载了");

    }

    @Override
    protected void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("我是Filter，我执行了");
        chain.doFilter(request,response);
    }
}
