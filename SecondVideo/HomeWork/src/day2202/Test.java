package day2202;

import java.io.*;

public class Test {

    public static void main(String[] args) {
        try {
            copyData();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyData() throws IOException {
        int a = 10;
        char c = 'a';
        double d = 2.5;
        boolean b = true;
        String str = "尚硅谷";

        DataInputStream dis = new DataInputStream(new FileInputStream("data.dat"));
        DataOutputStream dos = new DataOutputStream(new FileOutputStream("data.dat"));
        dos.writeInt(a);
        dos.writeChar(c);
        dos.writeDouble(d);
        dos.writeBoolean(b);
        dos.writeUTF(str);
        int a1 = dis.readInt();
        char c1 = dis.readChar();
        double d1 = dis.readDouble();
        boolean b1 = dis.readBoolean();
        String str1 = dis.readUTF();
        System.out.println(a1);
        System.out.println(c1);
        System.out.println(d1);
        System.out.println(b1);
        System.out.println(str1);

    }
}
