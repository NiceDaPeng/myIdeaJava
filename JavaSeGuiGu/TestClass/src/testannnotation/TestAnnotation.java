package testannnotation;

import java.io.FileReader;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Properties;

public class TestAnnotation {


    public static void main(String[] args)  {

//        @SuppressWarnings("unused")
//        String str = "abc";
//        System.out.println(str);
//
        //创建一个Properties对象
        Properties pro = new Properties();
        try {
            //加载一个基本流对象
            pro.load(new FileReader("TestClass\\src\\testannnotation\\Test.properties"));
            //根据键获取对应的值
            String value = pro.getProperty("key1");
            //如果我们想要遍历其中的键值对 那么就需要获取一个键的集合
            //Enumeration和Iterator用法类似
            @SuppressWarnings("unchecked")
            Enumeration enumeration = pro.propertyNames();
            while (enumeration.hasMoreElements()){
                String str = (String)enumeration.nextElement();
                String property = pro.getProperty(str);
                System.out.println(str+"="+property);
            }
//            System.out.println(value);
        } catch (IOException e) {
            e.printStackTrace();
        }

//        FileReader read = null;
//        try {
//            read = new FileReader("Test.properties");
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        BufferedReader buff = new BufferedReader(read);
//        String s = null;
//        try {
//            s = buff.readLine();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        System.out.println(s);
    }
}
