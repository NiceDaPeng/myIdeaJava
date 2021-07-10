package controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.ProgressListener;
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

public class SaveFileController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        DiskFileItemFactory factory = new DiskFileItemFactory();
        factory.setSizeThreshold(1024000000);
        ServletFileUpload upload = new ServletFileUpload(factory);
        upload.setFileSizeMax(1024000);
        upload.setSizeMax(10240000);
        upload.setProgressListener(new ProgressListener() { //监测组件上传的进度
            @Override
            public void update(long l, long l1, int i) {
                //三个参数的作用，
                /**
                 * long l:已经上传的字节个数     以4096为单位，上传这些个字节触发一次。直到上传完成位置
                 * long l1:表示上传文件的总字节数：固定的，
                 * l和l1相除就得到一个百分比了。但是现在完成不了。
                 * int i:表示正在上传第几个组件。因为item中不止是文件还有普通组件。
                 */
                System.out.println("正在上传第"+i+"个组件,已经上传"+(int)(((double)l/(double)l1)*100)+"%");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        try {
            List<FileItem> itemList = upload.parseRequest(request);
            for (FileItem item :
                    itemList) {
                if (item.isFormField()){
                    String key = item.getFieldName();
                    String fileName = item.getName();
                    String value = item.getString("UTF-8");
                    System.out.println(key+"--"+value+"--"+fileName);

                } else {
                    String fileName = item.getName();
//                    InputStream inputStream = item.getInputStream();
                    String realPath = this.getServletContext().getRealPath("/");//获取当前项目的根路径
                    item.write(new File("E://testFile/"+fileName));
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
