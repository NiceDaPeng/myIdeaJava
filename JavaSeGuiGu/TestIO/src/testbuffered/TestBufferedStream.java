package testbuffered;

import java.io.*;

public class TestBufferedStream {

    public static void main(String[] args) {

        File file = new File("E:\\testIO\\test3.txt");
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;

        try {
            bis = new BufferedInputStream(fis);
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file,true);
            bos = new BufferedOutputStream(fos);
            String str = "helloworld";
            byte[] bytes = str.getBytes();
            bos.write(bytes);
            bos.flush();
            int read = fis.read();
            while (read != -1){
                System.out.print((char)read);
                read = fis.read();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
