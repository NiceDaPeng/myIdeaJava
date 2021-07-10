package testinputstream;

import java.io.*;

public class TestCopyDirectory {

    public static void main(String[] args) {

        TestCopyDirectory td = new TestCopyDirectory();
        File file = new File("E:\\PhotoOfLife");
        td.copyFile(file,"E:\\testIO");
    }

    public void copyFile(File file,String newPath){
        //获取当前file对象的绝对路径：比如说我现在传递的是一个文件夹的绝对路径
        //D:\01java基础（基础看这个，柴林燕讲的比刘优好）\day03_全天上课资料
        //然后对其进行拆分，从：开始拆分那么我们得到的结果就是C 和 后面的文件的路径名字。
        //然后用newPath和这个路径名字进行组合。
        //比如说我现在要复制到D盘下的test文件夹里面
        //那么newFilePath = D：\\test\\01java基础（基础看这个，柴林燕讲的比刘优好）\day03_全天上课资料
        //然后我们对这个路径构建一个File对象，这样我们就可以对其进行操作了。
        /*
        * 既然我们要的是复制原来的文件到新的路径
        * 那么我们就要看一下这是个文件还是一个文件夹，
        * 此时我们就要列出它的所有子元素
        * 如果子元素不为空 ，那么我们就在新的file对象那里创建一个文件夹。
        * 如果这个子元素的长度不为0，那么就说明里面有元素。
        * 我们遍历出每一个子元素，然后调用自己这个方法再对其进行判断是否是一个文件夹或者是文件。
        * 如果其是一个文件夹，我们就创建这个文件夹，如果其不是一个文件夹，我们就跳到else里面对其进行判断
        *
        * */

        String newFilePath = newPath +file.getAbsolutePath().split(":")[1];
        File newFile = new File(newFilePath);
        File[] files = file.listFiles();

        if (files != null){
            newFile.mkdir();
            System.out.println(newFile.getName()+"文件夹复制完毕");
            if (files.length != 0){
                for (File f: files){
                    this.copyFile(f,newPath);
                }
            }
        } else {
            FileInputStream fis = null;
            FileOutputStream fos = null;

            try {
                byte[]  b = new byte[1024];
                fis = new FileInputStream(file);
                fos = new FileOutputStream(newFile);
                int count = fis.read(b);
                while (count != -1){
                    fos.write(b,0,count);
                    fos.flush();
                    count = fis.read(b);
                }
                System.out.println(newFile.getName()+"复制完毕");

            } catch (IOException e) {
                e.printStackTrace();
            }  finally {
                try {
                    if (fis != null){
                        fis.close();
                    }
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
        }

    }
}
