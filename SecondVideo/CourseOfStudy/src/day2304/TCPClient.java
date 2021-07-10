package day2304;

import java.io.*;
import java.net.Socket;

public class TCPClient {

    public static void main(String[] args) {
        Socket socket = null;
        FileInputStream fis = null;
        FileOutputStream fos = null;
        OutputStream os = null;
        InputStream is = null;
        try {
            fis = new FileInputStream("E:\\PhotoOfLife\\psc.jpg");
            socket = new Socket("127.0.0.1",8888);
            os = socket.getOutputStream();
            byte[] b = new byte[1024];
            int len;
            while ((len = fis.read(b)) != -1){
                os.write(b,0,len);
            }
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
