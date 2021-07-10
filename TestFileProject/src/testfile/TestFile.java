package testfile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestFile {

    public static void main(String[] args) {

        File file = new File("bbb\\aaa.txt");
//        long time = file.lastModified();
//        Date date = new Date(time);
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        String format = sdf.format(date);
//        System.out.println(format);

//       if (file.isDirectory()){
//           String[] list = file.list();
//           for (int i = 0; i < list.length;i++){
//               System.out.println(list[i]);
//           }
//       }else {
//           System.out.println(file.getName());
//       }

//        File absoluteFile = file.getAbsoluteFile();
//        System.out.println(absoluteFile.getName());
//        System.out.println(file.getName());


//        File parentFile = file.getParentFile();
//        while (parentFile != null){
//            System.out.println(parentFile.getAbsolutePath());
//            parentFile = parentFile.getParentFile();
//        }

        //        File file = new File("D:\\test\\bbb\\inner\\InnerTest.txt");
//        File pfile = file.getParentFile();
//        while(pfile!=null){
//            System.out.println(pfile.getAbsolutePath());
//            pfile = pfile.getParentFile();//再找一遍
//        }
//        boolean read = file.canRead();
//        System.out.println("可读"+read);
//        boolean write = file.canWrite();
//        System.out.println("可写"+write);
//
//        boolean hidden = file.isHidden();
//        System.out.println("是否隐藏"+hidden);
//
//        boolean exe = file.canExecute();
//        System.out.println("是否可执行"+exe);
//
//        try {
//            System.out.println("创建文件是否成功"+file.createNewFile());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//        boolean mkdir = file.mkdir();
//        System.out.println("创建文件夹是否成功"+mkdir);
//        boolean mkdirs = file.mkdirs();
//        System.out.println("创建多级目录是否成功"+mkdirs);
//        try {
//            file.createNewFile();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        boolean delete = file.delete();
//        System.out.println(delete);

//        File absoluteFile = file.getAbsoluteFile();
//        String name = absoluteFile.getName();
//        System.out.println(name);
//        String absolutePath = absoluteFile.getAbsolutePath();
//        System.out.println(absolutePath);
//        System.out.println(absoluteFile);
//        boolean file1 = absoluteFile.isFile();
//        System.out.println(file1);

//        String parent = file.getParent();
//        System.out.println(parent);


    }
}
