package day2303;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) throws IOException{

        //创建客户端Socket绑定服务器IP地址和端口号
        Socket socket = new Socket("127.0.0.1",9999);
        //获取流对象
        OutputStream os = socket.getOutputStream();
        //向服务器写数据
        os.write("你好服务器".getBytes());
        InputStream is = socket.getInputStream();

        byte[] b = new byte[1024];
        int len = is.read(b);
        System.out.println(new String(b,0,len));
        is.close();
        os.close();
    }
}
