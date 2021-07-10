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
import java.io.InputStream;
import java.util.List;

public class SaveFileControllerTwo extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        try {
            //创建一个工厂对象，这个对象表示的就是整个磁盘
            DiskFileItemFactory factory = new DiskFileItemFactory();
            factory.setRepository(new File("E://ThresHold"));//设置缓存的地址
            factory.setSizeThreshold(10240000);
            ServletFileUpload upload = new ServletFileUpload(factory);
            upload.setSizeMax(1024000);//设置上传文件的大小
            List<FileItem> itemList = upload.parseRequest(request);
            for (FileItem item :
                    itemList) {
                if (item.isFormField()){ //如果是一个普通的组件
                    String name = item.getName();//获取name属性
                    String key = item.getFieldName(); //获取name属性的值。
//                    String uname = item.getString();//获取文本框的值
                    String value = item.getString("UTF-8");//如果文本框的值是中文的话，那么可以用这个来获取其value
                    System.out.println(name+"--"+key+"--"+value);
                } else {
                    String key = item.getFieldName();//获取组件的name属性
                    String realName = item.getName();//获取文件的名字
                    System.out.println(key+"--"+realName);
                    InputStream inputStream = item.getInputStream();
                    item.write(new File("E://testFile/"+realName));
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
