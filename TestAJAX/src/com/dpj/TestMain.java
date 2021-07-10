package com.dpj;


import java.io.File;
import java.io.IOException;

public class TestMain {

    public static void main(String[] args) throws IOException {

        File file = new File("E:/a/b/e");
        File file1 = new File("E:/a/b");
        boolean exists = file.exists();
        System.out.println(exists);
        file.createNewFile();
        file1.createNewFile();

        for (int i = 0; i < file1.list().length; i++) {
            System.out.println(file1.list()[i]);
        }

        File[] files = file1.listFiles();
        for (File file0 :
                files) {
            System.out.println(file0.getName());
        }
    }


    public static int sum(int num){

        if (num ==1){
            return 1;
        }
         return num + sum(num -1);
    }

    //递归删除文件夹
    public static void deleteFile(File dir){
        File[] contents = dir.listFiles();
        if (contents.length == 0){
            dir.delete();
            return;
        } else {
            for (File f :
                    contents) {
                if (f.isFile()){
                    f.delete();
                } else {
                    deleteFile(f);
                }
            }
        }
    }

    public static int getSum(int num){
        if (num == 1){
            return 1;
        } else {
            return num + getSum(num-1);
        }
    }
}
