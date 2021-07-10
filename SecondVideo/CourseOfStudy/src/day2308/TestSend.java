package day2308;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.nio.charset.StandardCharsets;

public class TestSend {

    public static void main(String[] args) throws Exception {
        //创建一个发送端，发送端的IP地址和端口号是自动获取的。
        DatagramSocket ds = new DatagramSocket();
        String str = "马上下课了";
        byte[] bytes = str.getBytes();
        InetAddress ip = InetAddress.getByName("127.0.0.1");
        //将数据打包指定接收端的IP地址和接收端的端口号
        DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length,ip,8888);
        //通过Socket来发送
        ds.send(dp);
        System.out.println("发送完毕");
        ds.close();
    }
}
