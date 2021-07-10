package testbuffered;

import java.io.*;

public class TestBufferedChar {

    public static void main(String[] args) {

        File file = new File("E:\\testIO\\Person.txt");

        FileReader fr = null;
        BufferedReader br = null;

        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String person = br.readLine();
            while (person != null){
                System.out.println(person);
                person = br.readLine();
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
