package day2306;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

public class TestServer {

    public static void main(String[] args) {

        ServerSocket server = null;
        InputStream is = null;
        DataInputStream dis = null;
        FileOutputStream fos = null;
        Socket soc = null;
        OutputStream os = null;
        try {
            File file = new File("E:\\testcode");
            server = new ServerSocket(8888);
            while (true){
                soc = server.accept();
                is = soc.getInputStream();
                os = soc.getOutputStream();
                dis = new DataInputStream(is);
                String endName = dis.readUTF();
                String fileName = file+"\\value"+System.currentTimeMillis()+new Random().nextInt(888888)+endName;
                fos = new FileOutputStream(fileName);
                byte[] bytes = new byte[1024];
                int len ;
                while ((len = dis.read(bytes)) != -1){
                    fos.write(bytes,0,len);
                    System.out.println(len);
                }
                System.out.println("下载完成");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                dis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                soc.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


}
