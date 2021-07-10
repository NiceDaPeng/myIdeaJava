package day2203;

import java.io.*;
import java.util.Date;

public class Test {

    public static void main(String[] args) {

        try {
            Message mes = new Message("邮差","我","一条信息",new Date());
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("message.dat"));
            oos.writeObject(mes);
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream("message.dat"));
            Object o = ois.readObject();
            System.out.println(o);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
