package testio;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TestIO {

    public static void main(String[] args) {

        File file = new File("E:\\test\\aaa\\innerc.txt");

        FileInputStream fis = null;

        try {
            fis = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int read = fis.read(bytes);
            while (read != -1){
                String value = new String(bytes,0,read);
                System.out.print(value);
                read = fis.read(bytes);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            if (fis != null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
