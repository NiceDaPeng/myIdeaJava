package day2305;

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
            File file = new File("E:\\");
            server = new ServerSocket(8888);
            soc = server.accept();
            is = soc.getInputStream();
            os = soc.getOutputStream();
            dis = new DataInputStream(is);
            String endName = dis.readUTF();
            String fileName = System.currentTimeMillis()+"number"+new Random().nextInt(88888)+endName;
            fos = new FileOutputStream(file.getName()+fileName);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = is.read(bytes)) != -1){
                fos.write(bytes,0,len);
            }
            os.write("上传完成".getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
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
