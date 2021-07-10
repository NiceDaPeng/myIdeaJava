package browser;

import org.junit.Test;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Browser {

    private Scanner input = new Scanner(System.in);
    //模拟一个浏览器打开的功能
    @Test
    public void open(){
        //输入url--统一资源定位符
        //统一资源定位符：就是一个字符串，协议名：//ip:port/文件夹/资源名？参数  问号后面是携带的参数
        //？后面的参数是key=value&key=value的格式 问号和后面的参数有可能没有
        System.out.println("请输入url：");
        String url = input.nextLine();
        parseURL(url);
    }

    //设计一个方法 负责解析url
    private void parseURL(String url){

        //找寻冒号和第一个斜杠所在的位置
        int colonIndex = url.indexOf(":");
        int slashIndex = url.indexOf("/");
        //截取ip地址和端口号
        String ip = url.substring(0, colonIndex);
        int port = Integer.parseInt(url.substring(colonIndex + 1, slashIndex));
        //截取内容和参数
        String contentAndParams = url.substring(slashIndex + 1);
        this.createAndSendReques(ip,port,contentAndParams);
    }

    //创建一个方法用来想服务器发送contentAndParams
    public void createAndSendReques(String ip,int port,String contentAndParams){
        try {
            //创建一个客户端，将内容发送到服务器
            Socket socket = new Socket(ip,port);
            PrintWriter out = new PrintWriter(socket.getOutputStream());
            //将url中用户的请求信息发送到服务器。
            out.write(contentAndParams);
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
