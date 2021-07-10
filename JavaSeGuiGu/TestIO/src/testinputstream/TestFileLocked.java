package testinputstream;

import java.io.*;

public class TestFileLocked {

    public static void main(String[] args) {
        File file = new File("E:\\test\\aaac.avi");
        File file1 = new File("E:\\test\\ddd.avi");
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream(file);
            fos = new FileOutputStream(file1);

            byte[] b = new byte[1024];
            int count = fis.read(b);
            while (count != -1){
                byte temp = b[100];
                b[100] = b[101];
                b[101] = temp;
                fos.write(b,0,count);
                fos.flush();
                count = fis.read(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
