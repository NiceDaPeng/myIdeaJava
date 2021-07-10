package day2304;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TCPServer {

    public static void main(String[] args) {
        ServerSocket server = null;
        FileOutputStream fos = null;
        InputStream is = null;
        try {
            server = new ServerSocket(8888);
            while (true){
                Socket socket = server.accept();
                File file = new File("E:\\test");
                if (!file.exists()){
                    file.mkdir();
                }
                String fileName = "source"+System.currentTimeMillis()+new Random().nextInt(999999)+".jpg";
                fos = new FileOutputStream(file.getName()+fileName);

                is = socket.getInputStream();
                byte[] b = new byte[1024];
                int len;
                while ((len =is.read(b)) != -1){
                    fos.write(b,0,len);
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            if (is != null){
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
