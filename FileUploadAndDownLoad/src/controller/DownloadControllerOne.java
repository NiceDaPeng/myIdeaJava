package controller;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class DownloadControllerOne extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取需要下载的文件的文件名
        String fileName = request.getParameter("fileName");
        //通过fileName找到服务器中真实文件的位置
        //找到文件得需要一个输入流，读取文件的内容
        InputStream inputStream = new FileInputStream(new File("E://testFile/"+fileName));
        //正常情况下将内容响应给浏览器，但是有可能会存在中文
        /**
         * 如果文件的名字含有中文可以通过如下方式处理
         */
        URLEncoder.encode(fileName,"UTF-8");//通过URLEncoder的encode方法来处理中文名字的问题。
        //设置响应的contentType  设置响应的信息的类型的
        response.setContentType("application/x-msdownload");
        response.setHeader("content-disposition","attachment;fileName="+fileName);
        //获取响应的输出流
        ServletOutputStream outputStream = response.getOutputStream();
        byte[] b = new byte[1024];
        int len = inputStream.read(b);
        while (len != -1){
            outputStream.write(b,0,len);
            outputStream.flush();
            len = inputStream.read(b);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
