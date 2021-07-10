package TestIOExce;

import java.io.*;

public class TestInAndOut {

    //设计一个方法用来读取文件并写入到一个另一个文件
    public void inAndOut(File file){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        if (file.isFile()) {

            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(new File("E:\\PhotoOfLife\\psc1.jpg"));
                byte[] bytes = new byte[1024];
                int read = fis.read(bytes);
                while (read != -1){

                    fos.write(bytes);
                    read = fis.read(bytes);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    if (fis != null){
                        fis.close();
                    }
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }

        }
    }


    public static void main(String[] args) {

        TestInAndOut tio = new TestInAndOut();
        tio.inAndOut(new File("E:\\PhotoOfLife\\psc.jpg"));
    }
}
