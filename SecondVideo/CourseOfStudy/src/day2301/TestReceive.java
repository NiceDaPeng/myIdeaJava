package day2301;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class TestReceive {

    public static void main(String[] args) {

        try {
            DatagramSocket ds = new DatagramSocket(9999);
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length);
            ds.receive(dp);

            byte[] data = dp.getData();
            int len = dp.getLength();
            System.out.println(new String(data,0,len));

            ds.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
