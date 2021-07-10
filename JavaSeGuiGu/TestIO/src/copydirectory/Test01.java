package copydirectory;

import java.io.*;

public class Test01 {

    public static void main(String[] args) {

    }

    public void copyFile(File file, String newPath){
        //获取文件的绝对路径
        String oldPath = file.getAbsolutePath();
        //根据文件原来的路径，来重新定位新路径
        String newFilePath = newPath+oldPath.split("-")[1];
        //创建新路径的文件对象。
        File newFile = new File(newFilePath);
        //获取源文件的子元素
        File[] files = file.listFiles();
        //如果里面有子元素，并且子元素里面的长度不为0，说明里面有东西。不是一个空文件夹
        if (files != null && files.length != 0){
            //创建文件夹
            newFile.mkdir();
            //遍历每一个文件对象出来，然后再对其进行判断。
            for (File f :
                    files) {
                copyFile(newFile, newFilePath);
            }
        } else {
            FileInputStream fis = null;
            FileOutputStream fos = null;

            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(newFile);
                byte[] bytes = new byte[1024];
                int len = 0;
                while ((len = fis.read(bytes)) != -1){
                    fos.write(bytes,0,len);
                }

            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (fis != null){
                    try {
                        fis.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (fos != null){
                    try{
                        fos.close();
                    }catch (IOException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
