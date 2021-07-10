package day2204;

import java.io.*;

public class TestMain {

    public static void main(String[] args) {

        try {
            FileInputStream fis = new FileInputStream("E:/users.txt");
            InputStreamReader isr = new InputStreamReader(fis,"UTF-8");
            char[] arr = new char[1024];
            int len;
            while ((len = isr.read(arr)) != -1){
                for (int i = 0; i < arr.length;i++){
                    System.out.print(arr[i]);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
