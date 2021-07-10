package testinputstream;

import java.io.*;

public class TestInputStream {

    public static void main(String[] args) {

        File file = new File("E:\\PhotoOfLife\\psc.jpg");

        FileInputStream fis  = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream("E:\\PhotoOfLife\\psc3.jpg");
            byte[] bytes = new byte[1024];
            int read  = fis.read(bytes);
            while (read != -1){

                fos.write(bytes);
                fos.flush();
                read = fis.read(bytes);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
