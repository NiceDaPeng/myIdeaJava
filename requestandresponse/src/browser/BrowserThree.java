package browser;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class BrowserThree {

    private Scanner input = new Scanner(System.in);
    //设计一个方法相当于打开浏览器
    public void open(){
        System.out.println("输入URL：");
        String url = input.nextLine();
        this.parseUrl(url);
    }

    //设计一个方法用来解析url,就是将url转变为我们需要的内容
    public void parseUrl(String url){
        //获取第一次出现冒号的索引位置
        int maohaoIndex = url.indexOf(":");
        //获取第一次出现斜杠的位置
        int xiegangIndex = url.indexOf("/");
        //因为url的格式为：ip：端口号/资源名？key = value&key=value
        //通过截取字符串可以得到ip地址和端口号和请求的资源名还有参数，分别获取
        String ip = url.substring(0,maohaoIndex);
        String port = url.substring(maohaoIndex+1,xiegangIndex);
        String contentAndParams = url.substring(xiegangIndex+1);
        this.sendRequest(ip,port,contentAndParams);
    }

    //设计一个方法用来向服务器发送消息
    public void sendRequest(String ip,String port,String contentAndParams){
        //创建一个客户端
        try {
            Socket socket = new Socket(ip, Integer.parseInt(port));
            OutputStream outputStream = socket.getOutputStream();
            //将低级流转为高级流，这样可以读取一行。
            PrintWriter out = new PrintWriter(outputStream);
            //将解析到的内容发送到服务器
            out.println(contentAndParams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //设计一个方法用来解析服务器的响应内容
}
