package copydirectory;

import java.io.*;

public class Test {

    public static void main(String[] args) {
        File file = new File("E:\\PhotoOfLife");
        Test t = new Test();
        t.copyOfFile(file, "E:\\testIO");
    }

    //设计一个方法用来拷贝文件夹

    public void copyOfFile(File file, String newpath) {

        String oldPath = file.getAbsolutePath();
        String newFilePath = newpath + oldPath.split(":")[1];
        File newFile = new File(newFilePath);
        File[] files = file.listFiles();
        if (files != null) {
            newFile.mkdir();
            if (files.length != 0) {
                for (File f : files) {
                    copyOfFile(f, newpath);
                }
            }
        } else {
            FileInputStream fis = null;
            FileOutputStream fos = null;
            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(newFile);
                byte[] b = new byte[1024];
                int count = fis.read(b);
                while (count != -1) {
                    fos.write(b, 0, count);
                    fos.flush();
                    count = fis.read(b);
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
                    try {
                        fos.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
