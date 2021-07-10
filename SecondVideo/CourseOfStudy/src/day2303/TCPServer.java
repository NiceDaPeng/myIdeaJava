package day2303;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

    public static void main(String[] args) throws IOException {


        //创建一个服务器端，向系统要指定的端口号
        ServerSocket socket = new ServerSocket(9999);
        //通过accept方法来获取要和服务器链接的对象
        Socket accept = socket.accept();
        //通过socket对象来获取网络输入流对象。
        InputStream is = accept.getInputStream();
        //读取客户端发来的信息
        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b,0,len));
        //通过socket客户端获取网络字节输出流对象
        OutputStream os = accept.getOutputStream();
        //向客户端回传一个信息
        os.write("收到谢谢".getBytes());
        accept.close();
        socket.close();

    }
}
