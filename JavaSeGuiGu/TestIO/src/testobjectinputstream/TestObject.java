package testobjectinputstream;

import java.io.*;

public class TestObject {

    public static void main(String[] args) {

        File file = new File("E:/users.txt");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ObjectOutputStream oos = null;
        FileOutputStream fos = null;
        Person person = new Person("张三",20);

        try {

            fos = new FileOutputStream(file,true);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(person);

            fis = new FileInputStream(file);
            ois = new ObjectInputStream(fis);
            Object o = ois.readObject();
            System.out.println(o);


        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
