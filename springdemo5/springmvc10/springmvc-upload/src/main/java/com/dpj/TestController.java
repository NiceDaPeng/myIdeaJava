package com.dpj;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;

@Controller
public class TestController {

    @RequestMapping("testOne")
    public String testOne(){
        System.out.println("controller.testOne");
        return "welcome.jsp";
    }


    /**
     * 文件上传的时候，需要一个临时的存储：
     * factory.setSizeThreshold();//设置缓存的大小，大小通常是10240000，
     * 缓存默认是在Tomcat容器里的，
     * factory.setRePository(new File("路径"));
     * @param text
     * @param upload
     * @return
     * @throws IOException
     */
    @RequestMapping("testUpload")
    public String testUpload(String text, MultipartFile upload) throws IOException {
        System.out.println("TestController.testUpload");
        //获取文件名字
        String fileName = upload.getName();
        String contentType = upload.getContentType();
        System.out.println(contentType);
        //获取文件对象  告诉上传的位置
        //upload帮我们做传输
        upload.transferTo(new File("E:/images/",fileName));
        return "welcome.jsp";
    }

    //文件下载
    @RequestMapping("downloadFile")
    public ResponseEntity<byte[]> downloadFile(String fileName) throws IOException {
        //fileName是浏览器发送来的请求的文件的名字
        //读取文件
        File file = new File("E:/images/"+fileName);
        //设置响应信息相关的
        //如果有中文，需要处理，springmvc会帮我们处理字符集
        fileName = new String(fileName.getBytes("UTF-8"),"UTF-8");
        HttpHeaders headers = new HttpHeaders();  //headers的目的是为了设置响应头信息
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",fileName);

        //将响应信息，存入一个返回值对象内即可--ResponseEntity
        //通过FileUtils去读取文件，读取完以后，放到bytes数组中。
        byte[] bytes = FileUtils.readFileToByteArray(file);
        //第一个参数是，存储文件信息的数组，headers表示的是响应头信息，第三个信息，表示创建新文件下载文件以后处理的方式
        return new ResponseEntity(bytes,headers, HttpStatus.CREATED);
    }
}
