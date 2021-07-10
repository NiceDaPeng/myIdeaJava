package day2204;

import java.io.*;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        listFile(new File("D:\\01java基础（基础看这个，柴林燕讲的比刘优好）\\day23_全天上课资料"));
    }

    public static void TestPrint(){
        try {
            Scanner input = new Scanner(System.in);
            System.out.println("请输入第一句话");
            String one = input.nextLine();
            System.out.println("请输入第一句话");
            String two = input.nextLine();
            System.out.println("请输入第一句话");
            String three = input.nextLine();
            System.out.println("请输入第一句话");
            String four = input.nextLine();
            PrintStream ps = new PrintStream("word.txt");
            ps.println(one);
            ps.println(two);
            ps.println(three);
            ps.println(four);


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void listFile(File file){
        File[] files = file.listFiles();
        if (files != null){
            if (files.length != 0) {
                for (File f :
                        files) {
                    listFile(f);
                }
            }
        }
        System.out.println(file.getName());
    }

    public void copyFile(File file,String dest) throws IOException {

        String oldPath = file.getAbsolutePath();
        String newPath = dest+oldPath.split(".")[1];
        File newFile = new File(newPath);
        File[] files = file.listFiles();
        if (files != null){
            newFile.mkdir();
            if (files.length != 0){
                for (File f :
                        files) {
                    copyFile(f,dest);
                }
            }
        }
        newFile.createNewFile();
    }
}
