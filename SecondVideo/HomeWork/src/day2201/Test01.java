package day2201;

import java.io.*;

public class Test01 {

    public static void main(String[] args) throws IOException {
        File src = new File("D:/01java基础（基础看这个，柴林燕讲的比刘优好）/day22_全天上课资料/day22_homework/我想对你说.txt");
        File dest = new File("testIO/老师的话.txt");
        copyFile1(src,dest);
    }

    public void copyFile(File file) throws IOException{
        FileInputStream fis = new FileInputStream(file);
        BufferedInputStream bis = new BufferedInputStream(fis);
        FileOutputStream fos = new FileOutputStream("testIO/Java复习笔记.md");
        BufferedOutputStream bos = new BufferedOutputStream(fos);
        byte[] b = new byte[1024];
        int len;
        while ((len = bis.read(b)) != -1){
            bos.write(b,0,len);
            bos.flush();
        }
    }

    public static void copyFile1(File src,File dest) throws IOException{

        FileInputStream fis = new FileInputStream(src);
        FileOutputStream fos = new FileOutputStream(dest);
        OutputStreamWriter osw = new OutputStreamWriter(fos);
        byte[] chars = new byte[1024];
        int len;
        while ((len = fis.read(chars)) != -1){
            String str = new String(chars,0,len,"GBK");
            osw.write(str);
            osw.flush();
        }
    }
}
