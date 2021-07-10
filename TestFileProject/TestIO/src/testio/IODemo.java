package testio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IODemo {

    public static void main(String[] args) {

//        String str = "12345我爱你中国";
//        byte[] bytes1 = str.getBytes();

        try {
            FileInputStream  fis = new FileInputStream("E:\\test\\aaa\\innerc.txt");
            byte[] bytes = new byte[5];
            int count = fis.read(bytes);
            while(count != -1){
                String str = new String(bytes,0,count);
                System.out.print(str);
                count = fis.read(bytes);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

//        try {
//            File file = new File("E:\\test\\aaa\\innerc.txt");
//            FileInputStream fis = new FileInputStream(file);
//            int read = fis.read();
//            while (read != -1){
//                System.out.print((char)read);
//                read = fis.read();
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
