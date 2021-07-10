package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Serverone {

    public void openServer(){
        try {
            ServerSocket server  = new ServerSocket(9999);
            while (true) {
                Socket socket = server.accept();
                new MyThread(socket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
