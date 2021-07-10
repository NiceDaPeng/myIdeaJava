package server;

//这个类出现的目的就是为了
public abstract class HttpServlet {

    public abstract void service(HttpServletRequest request,HttpServletResponse response);
}
