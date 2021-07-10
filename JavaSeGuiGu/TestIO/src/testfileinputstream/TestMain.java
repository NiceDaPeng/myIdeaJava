package testfileinputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class TestMain {

    public static void main(String[] args) {
        File file = new File("E:\\test");
        TestMain tm = new TestMain();
        tm.getSon(file);

//        File file = new File("E:\\testIO\\1.txt");
//        try {
//            FileInputStream fis = new FileInputStream(file);
//            byte[] b = new byte[1024];
//            int count = fis.read(b);
//            while (count != -1){
//                System.out.println(new String(b));
//                count = fis.read();
//            }
//
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }

    //设计一个方法用来遍历文件夹的子元素
//    public void getSon(File file){
//        File[] files = file.listFiles();
//       if (files != null && files.length != 0){
//            for (File file1:files){
//                getSon(file1);
//            }
//        }
//        file.delete();
//
//    }

    //设计一个方法用来遍历文件夹
    public void getSon(File file){
        File[] files = file.listFiles();
        if (files != null && files.length != 0){
            for (File f : files){
                this.getSon(f);
            }
        }
    }
}
