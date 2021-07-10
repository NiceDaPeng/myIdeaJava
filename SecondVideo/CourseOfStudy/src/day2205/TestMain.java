package day2205;

import java.io.*;

public class TestMain {

    public static void main(String[] args) {

        Student stu = new Student();
        stu.setName("哇哈哈");
        stu.setPrice(5.5);
        File file = new File("test22.dat");
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {

            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            fos = new FileOutputStream(file);
            oos = new ObjectOutputStream(fos);

            oos.writeObject(stu);
            oos.flush();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }  finally {
            try {
                if (fis != null)
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                if (ois != null)
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
