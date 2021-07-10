package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Properties;

public class ServerThree {
    private static int port;
    static {
        Properties pro = new Properties();
        try {
            pro.load(ServerThree.class.getClassLoader().getResourceAsStream("port.properties"));
            String port1 = pro.getProperty("port");
            port = Integer.parseInt(port1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //开启服务器
    public void openServer(){
        System.out.println("服务器启动了");
        try {
            ServerSocket serverSocket = new ServerSocket(port);
            while (true){
                //每次监听客户端的链接，监听到链接就单独的为其开启一个线程进行工作
                Socket server = serverSocket.accept();
                //将客户端的链接传给单独的线程，让线程进行工作
                new ThreadThree(server).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
