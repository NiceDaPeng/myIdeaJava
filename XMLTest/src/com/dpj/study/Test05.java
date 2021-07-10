package com.dpj.study;

import java.io.*;

public class Test05 {

    public static void main(String[] args) {

        File file = new File("src/images/java.jpg");
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis= new FileInputStream(file);
            fos = new FileOutputStream("E:\\images\\good.jpg");
            byte[] bytes = new byte[1024];
            int len=0;
            while ((len = fis.read(bytes)) > 0){
                fos.write(bytes,0,len);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {

                if (fis != null ) {
                    fis.close();
                }
                if (fos != null) {
                    fos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
