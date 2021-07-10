package testtcpip;

import java.io.*;
import java.net.Socket;

public class TestClient {

    public static void main(String[] args) {
        Socket socket = null;
        BufferedReader br = null;
        try {
            socket = new Socket("127.0.0.1",8888);
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String value = br.readLine();
            System.out.println(value);
            socket.shutdownInput();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
