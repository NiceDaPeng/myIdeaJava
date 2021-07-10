package day2301;

import java.io.IOException;
import java.net.*;

public class TestSend {

    public static void main(String[] args) {

        try {
            DatagramSocket ds = new DatagramSocket();
            String str = "下课了";
            byte[] bytes = str.getBytes();

            InetAddress ip = InetAddress.getByName("127.0.0.1");
            DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length,ip,9999);
            ds.send(dp);
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
