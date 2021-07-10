package homework2021_4_2;

import java.io.*;

public class OpreateFile {

    //设计一个方法实现文件的复制

    public boolean copyFile(File file,String path){
        FileInputStream fis = null;
        FileOutputStream fos = null;
        //1,创建一个输入流
        try {
             fis = new FileInputStream(file);
            File newFile = new File(path+"\\"+file.getName());
            fos  = new FileOutputStream(newFile);
            byte[] bytes = new byte[1024];
            int read = fis.read(bytes);

            while (read != -1){
                //做点手脚，每一次数组的前两个元素的位置互换
                fos.write(bytes,0,read);
                fos.flush();
                read = fis.read(bytes);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                fis.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return true;

    }

    public static void main(String[] args) {

        OpreateFile of = new OpreateFile();
        File file = new File("D:\\01java基础（基础看这个，柴林燕讲的比刘优好）\\day01_全天上课资料" +
                "\\day01_video\\day01_01JavaSE阶段内容介绍.avi");
        boolean b = of.copyFile(file, "E:\\test");
        System.out.println(b);
    }

}
