package readerandwriter;

import java.io.*;

public class TestFileReader {

    public static void main(String[] args) {

        File file = new File("E:\\testIO\\test\\aaa\\innera\\innerinnera\\innerd.txt");
        FileReader fr = null;
        FileWriter fw = null;
        try {
            fr = new FileReader(file);
            fw = new FileWriter("E:\\testIO\\test\\aaa\\innera\\innerinnera\\innera.txt");
            char[] read = new char[1024];
            int count = fr.read(read);
            while (count != -1){
//                System.out.print(new String(read,0,count));
                fw.write(read,0,count);
                fw.flush();
                count = fr.read(read);
            }
            System.out.println("写入成功");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
