package com.dpj.test;

import java.io.*;

public class TestOne {

    public static void main(String[] args) throws IOException {


        File file = new File("e:/a/b/c.txt");
        InputStream is = new FileInputStream(file);
//        if (file.exists()){
//
//            int value = 0;
//            while (true){
//                value = is.read();
//                if (value == -1){
//                    break;
//                }
//                System.out.print((char)value);
//            }
//        } else {
//            file.createNewFile();
//        }
//        byte[] b = new byte[1024];
//        int len;
//        while ((len = is.read(b)) != -1){
//            System.out.print(new String(b));
//        }

        OutputStream os = new FileOutputStream("e:/a/b/c.txt");
        String str = "abc";

        os.write(str.getBytes());


    }
}
