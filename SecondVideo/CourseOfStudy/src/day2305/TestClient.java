package day2305;

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
        FileInputStream fis = null;
        FileOutputStream fos = null;
        DataInputStream dis = null;
        DataOutputStream dos = null;
        InputStream is = null;
        OutputStream os = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            os = socket.getOutputStream();
            dos = new DataOutputStream(os);
            dos.writeUTF(endName);
            fis = new FileInputStream(filePath);
            byte[] bytes = new byte[1024];
            int len;
            while ((len = fis.read(bytes)) != -1){
                os.write(bytes,0,len);
            }
            os.write("上传消息".getBytes());
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
