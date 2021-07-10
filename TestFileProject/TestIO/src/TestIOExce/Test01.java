package TestIOExce;

import java.io.File;
import java.io.IOException;

public class Test01 {

    //1、使用绝对路径，在D盘下创建一个testIO文件夹，然后在testIO文件夹中创建一个1.txt文件

    public static void main(String[] args) {

        File file = new File("IODemo\\1.txt");
//        boolean mkdir = file.mkdir();
//        System.out.println(mkdir);

//        try {
//            boolean newFile = file.createNewFile();
//            System.out.println(newFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        boolean mkdir = file.mkdir();
//        System.out.println(mkdir);
//        boolean delete = file.delete();
//        System.out.println(delete);
//        boolean mkdir = file.mkdir();
//        try {
//            boolean newFile = file.createNewFile();
//            System.out.println(newFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        System.out.println(mkdir);

        File[] files = file.listFiles();



    }
}
