package browser;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Browserone {
    private Scanner input = new Scanner(System.in);
    public void open(){
        System.out.println("输入url：");
        String url = input.nextLine();
        //对url进行解析
    }

    //设计一个方法对url进行解析
    public void parseURL(String url){
        int maohaoIndex = url.indexOf(":");
        int xiegangIndex = url.indexOf("/");
        String ip = url.substring(0, maohaoIndex);
        int port =Integer.parseInt( url.substring(maohaoIndex+1,xiegangIndex));
        String contentAndparams = url.substring(xiegangIndex+1);
    }

    //设计一个方法用来将解析完的内容发送的服务器
    public void sendContent(String ip,int port,String contentAndParams){
        try {
            Socket socket = new Socket(ip,port);
            OutputStream outputStream = socket.getOutputStream();
            PrintWriter writer = new PrintWriter(outputStream);
            writer.write(contentAndParams);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
