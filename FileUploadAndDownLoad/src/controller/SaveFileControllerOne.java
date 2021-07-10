package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class SaveFileControllerOne extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try {
            //创建一个工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //工厂是不干活的，需要创建一个ServletFileUpload来进行上传,构造方法中需要factory帮忙。
            ServletFileUpload upload = new ServletFileUpload(factory);
            //通过upload解析upload对象，解析的目的是因为请求携带的信息都在request对象里。
            //所有解析出来的信息都放在了FileItem的集合里面
            List<FileItem> itemList = upload.parseRequest(request);
            //将list中所有的item元素遍历，for循环
            for (FileItem item :
                    itemList) {
                if (item.isFormField()){  //如果item是一个普通的组件
                    //不能使用request.getParameter("key")来获取，因为request对象已经被解析了。
                    String uname = item.getFieldName();//获取组件的name属性
//                    String uvalue = item.getString();//获取组件的value属性的值的。
                    String uvalue = item.getString("UTF-8");//利用重载的方法来处理字符集的问题同时得到value。
                    System.out.println(request.getParameter("uname"));
                    System.out.println(uname+"--"+uvalue);
                } else{  //证明是一个文件。  文件上传只能传文件不能传文件夹


                }
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }
}
