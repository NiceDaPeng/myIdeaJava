package day2308;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class TestReceive {


    //
    public static void main(String[] args) throws Exception{
        //接收方也要准备Socket
        DatagramSocket ds = new DatagramSocket(8888);
        byte[] bytes = new byte[1024];
        //接收方的DatagramPacket
        DatagramPacket dp = new DatagramPacket(bytes,bytes.length);
        ds.receive(dp);

        //将数据从包里面拆解出来
        byte[] bytes1 = dp.getData();
        int len = dp.getLength();
        System.out.println(new String(bytes1,0,len));

        //断开
        ds.close();
    }
}
