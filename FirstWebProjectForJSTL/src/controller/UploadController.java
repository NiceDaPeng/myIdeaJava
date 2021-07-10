package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadController extends HttpServlet {


    @Override
    protected void doPost(HttpServletRequest requset, HttpServletResponse response) throws ServletException, IOException {

        try {
            //获取一个工厂对象
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setSizeThreshold(102400000);//设置缓冲区的大小
//            factory.setRepository(new File(""));//设置缓冲区的位置
            //创建一个上传文件用的对象
            ServletFileUpload upload  = new ServletFileUpload(factory);
//            upload.setFileSizeMax(1024*1024*1024);//设置每个上传文件的大小
//            upload.setSizeMax(1024*1024*1024*1024);//设置总共可以上传的文件大小
            //解析请求发送来的内容
            List<FileItem> itemList = upload.parseRequest(requset);
            for (FileItem item :
                    itemList) {
                if (item.isFormField()){
                    String fieldName = item.getFieldName();
                    String name = item.getName();
                    String value = item.getString("UTF-8"); //获取到请求的value
                } else {
                    String fieldName = item.getName();
                    //写入到服务器的磁盘
                    item.write(new File("E://testFile/"+fieldName));
                    //如果我们想要保存在当前醒目的根目录下可以通过一下方法来获取当前项目的根目录
                    String realPath = this.getServletContext().getRealPath("/");

                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
