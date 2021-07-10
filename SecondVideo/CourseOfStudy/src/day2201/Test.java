package day2201;

import java.io.File;

public class Test {

    public static void main(String[] args) {

        File file = new File("E:/testIO");
        Test t = new Test();
        t.deleteFile(file);
    }

    //设计一个方法用来遍历一个文件的子文件
    public void getLists(File file){
        if (file.isDirectory()){
            File[] files = file.listFiles();
            for (File f :
                    files) {
                getLists(f);
            }
        }
        System.out.println(file.getName());
    }

    //设计一个方法用来获取文件夹的大小
    public long getSize(File file){
        if (file.isFile()){
            return file.length();
        }else if (file.isDirectory()){
            long sum = 0;
            File[] files = file.listFiles();
            for (File f :
                    files) {
                sum += getSize(f);
            }
            return sum;
        }
        return 0;
    }

    //设计一个方法用来遍历文件
    public void getValues(File file){
        File[] files = file.listFiles();
        if (files !=null && files.length != 0){
            for (File f :
                    files) {
                getValues(f);
            }
        }
        System.out.println(file.getName());
    }
    
    //设计一个方法用来删除文件夹
    public void deleteFile(File file){
        File[] files = file.listFiles();
        if (files != null){
            if (files.length != 0){
                for (File f :
                        files) {
                    deleteFile(f);
                }
            }
        }
        file.delete();
    }
}
