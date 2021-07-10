package day2301;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Test02 {

    public static void main(String[] args) {


        try {
            DatagramSocket ds = new DatagramSocket(8888);
            byte[] bytes = new byte[1024];
            DatagramPacket dp = new DatagramPacket(bytes,0,bytes.length);
            ds.receive(dp);

            byte[] data = dp.getData();
            int len = dp.getLength();
            System.out.println(new String(data,0,len));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
