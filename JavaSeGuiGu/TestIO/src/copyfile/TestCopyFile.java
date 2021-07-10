package copyfile;

import testinputstream.TestCopyDirectory;

import java.io.*;

public class TestCopyFile {

    public static void main(String[] args) {

        TestCopyFile tcf = new TestCopyFile();
        tcf.copyOfFile(new File("E:\\test"),"E:\\testIO");

    }

    public void copyOfFile(File file,String newPath){

        String oldPath = file.getAbsolutePath();
        String newFilePath = newPath+oldPath.split(":")[1];
        File newFile = new File(newFilePath);
        File[] files = file.listFiles();
        if (files != null){
            newFile.mkdir();
            if (files.length != 0){
               for (File f: files){
                   this.copyOfFile(f,newPath);
               }
            }

        } else {
            FileInputStream fis = null;
//            BufferedInputStream bis = null;
            FileOutputStream fos = null;
//            BufferedOutputStream bos = null;

            try {
                fis = new FileInputStream(file);
                fos = new FileOutputStream(newFile);
//                bis = new BufferedInputStream(fis);
//                bos = new BufferedOutputStream(fos);

                byte[] bytes = new byte[1024];
                int read = fis.read(bytes);
                while (read != -1){
                    fos.write(bytes,0,read);
                    fos.flush();
                    read = fis.read(bytes);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {

            }
        }

    }
}
