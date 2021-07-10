package controller;

import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;

public class ReDownLoadController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String fileName = request.getParameter("fileName");
        InputStream inputStream = new FileInputStream(new File("E://testFile/"+fileName));
        URLEncoder.encode(fileName,"UTF-8");
        ServletOutputStream outputStream = response.getOutputStream();
        response.setContentType("application/x-msdownload");
        response.setHeader("content-disposition","attachment;fileName="+fileName);
        byte[] bytes = new byte[1024];
        int len = inputStream.read(bytes);
        while (len != -1){
            outputStream.write(bytes,0,len);
            outputStream.flush();
            len = inputStream.read(bytes);
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
