package day2306;

import java.io.*;
import java.net.Socket;

public class TestClient {

    public static void main(String[] args) {
        uploadFile("E:\\PhotoOfLife\\psc.jpg");
    }

    public static void uploadFile(String filePath){
        int lastIndex = filePath.lastIndexOf(".");
        String firstName = filePath.substring(0, lastIndex);
        String endName = filePath.substring(lastIndex);

        Socket socket = null;
        DataOutputStream dos = null;
        OutputStream os = null;
        InputStream is= null;
        DataInputStream dis = null;
        FileInputStream fis = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            os = socket.getOutputStream();
            is = socket.getInputStream();
            dis = new DataInputStream(is);
            dos = new DataOutputStream(os);
            dos.writeUTF(endName);
            fis = new FileInputStream(filePath);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1){
                dos.write(bytes,0,len);
            }
            System.out.println("上传完成");
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket != null) {
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
