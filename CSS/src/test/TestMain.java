package test;

import java.io.*;

public class TestMain {

    public static void main(String[] args) {

        File file = new File("e:/a/1.txt");
        try {
            FileReader reader = new FileReader(file);
            FileWriter writer = new FileWriter(file,true);
            BufferedReader br = new BufferedReader(reader);
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(file));
            DataOutputStream ds  = new DataOutputStream(new FileOutputStream(file));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
