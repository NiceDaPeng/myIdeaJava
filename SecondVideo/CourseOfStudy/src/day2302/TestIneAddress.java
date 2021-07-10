package day2302;

import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class TestIneAddress {

    public static void main(String[] args) {

        InetAddress ipv4 = null;
        InetAddress ipv6 = null;
        try {
            ipv4 = Inet4Address.getLocalHost();
            ipv6 = Inet6Address.getLocalHost();
            System.out.println(ipv4);
            System.out.println(ipv6);

            InetAddress baidu = InetAddress.getByName("www.baidu.com");
            System.out.println(baidu);
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
