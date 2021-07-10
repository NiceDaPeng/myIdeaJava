package testrecursion;

import java.io.File;

public class TestRecursionFile {

    //设计一个方法用来遍历文件夹中的所有元素

//    public void showFile(File file){
//
//        //首先获取这个文件的子元素 得到一个File类型的数组
//        File[] files = file.listFiles();
//
//        //判断这个数组的引用是否为空，如果为空则说明这是个文件
//        //如果不为空，则说明它是一个文件夹。
//        //判断这个数组的长度是否为0，为0则说明是个空文件夹，不为0 则说明里面有元素。
//        if (files != null && files.length != 0){
//            //遍历除每一个子元素
//            for (File f : files){
//                //递归调用这个方法，将里面的元素作为参数。
//                this.showFile(f);
//            }
//        }
//
//        System.out.println(file.getAbsolutePath());
//
//    }

    public static void main(String[] args) {

        File file = new File("E:\\test");
        TestRecursionFile trf = new TestRecursionFile();
//        trf.showFile(file);
        trf.deleteFile(file, false);

    }

    //设计一个方法用来遍历一个File对象的所有子文件
    public void showFile(File file) {

        //获得当前文件的子元素对象
        File[] files = file.listFiles();
        //判断这个数组的引用是否为空，为空则说明这没有文件，直接打印输出即可，如果不为空则说明里面是有元素的
        //有元素再判断当前元素的长度是否为0，如果为0 则说明是空文件夹。
        if (files != null && files.length != 0) {

            for (File f :
                    files) {
                showFile(f);
            }
        }

        System.out.println(file.getAbsolutePath());
    }

    //设计一个方法用来删除文件夹
    public void deleteFile(File file, boolean flag) {
        File[] files = file.listFiles();
        if (files != null && files.length != 0) {
            for (File f :
                    files) {
                deleteFile(f, flag);
            }
        }

        if (flag == true)
            file.delete();
        else
            System.out.println(file.getAbsolutePath());
    }
}
