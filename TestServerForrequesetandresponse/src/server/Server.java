package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    //设计一个方法启动服务器

    public void startServer(){
        System.out.println("启动服务器==");
        try {
            //创建一个服务器
            ServerSocket serverSocket = new ServerSocket(9999);
            //等待某一个客户端的链接
            //服务器只有一个，但是客户端有很多个，所以每个客户端的链接都要单独开一个线程。
          while (true){
              //每一个客户端的链接，都单独的开启一个线程去做它自己的事情。
              Socket socket = serverSocket.accept();
              //启动一个线程，负责当前浏览器发送过来的消息
              new MyThread(socket).start();
//              InputStream inputStream = socket.getInputStream();
//              BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
//              String content = br.readLine();
          }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
