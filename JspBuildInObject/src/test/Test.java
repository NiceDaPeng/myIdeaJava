package test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Test {

    public static void main(String[] args) {

        try {
            System.out.println("服务器启动了");
            ServerSocket server = new ServerSocket(9999);
            Socket socket = server.accept();
            InputStream is = socket.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(is));
            String value;
            while ((value = reader.readLine()) != null){
                System.out.println(value);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
