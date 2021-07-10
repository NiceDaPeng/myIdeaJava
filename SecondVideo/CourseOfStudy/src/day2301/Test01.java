package day2301;

import java.io.IOException;
import java.net.*;

public class Test01 {

    public static void main(String[] args) {

        try {
            DatagramSocket ds = new DatagramSocket();
            InetAddress ip = InetAddress.getByName("LocalHost");
            String str = "学会了";
            byte[] bytes = str.getBytes();
            DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length,ip,8888);
            ds.send(dp);
            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
