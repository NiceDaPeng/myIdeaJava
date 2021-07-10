package TestIOExce;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class TestCopyFile {

    public void copyFile(File file){


    }

    public void show(File file){

        File[] files = file.listFiles();
        while (files != null && files.length != 0){
            for (File f : files){
                this.show(f);
            }
        }

        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {

            fis = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int read = fis.read(bytes);
            while (read != -1){

            }
        } catch (IOException e){
            e.printStackTrace();
        } finally {
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
