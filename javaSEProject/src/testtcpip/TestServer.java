package testtcpip;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.time.LocalDateTime;

public class TestServer {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        BufferedWriter bw = null;

        try {
            System.out.println("服务器再8080端口监听");
            server = new ServerSocket(8888);
            while (true){
                socket = server.accept();
                bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream(),"Unicode"));
                bw.write("welcome to study java现在的时间时：" + LocalDateTime.now());
                bw.newLine();
                bw.close();
                socket.close();
            }


        } catch (IOException e) {
            e.printStackTrace();
        } finally {
//            if (bw != null) {
//                try {
//                    bw.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
//            if (socket != null) {
//                try {
//                    socket.close();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            }
        }
    }
}
