package util;

import domain.Question;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class QuestionFileReader {
    //程序执行时 将文件中的所有题目 一次性都读取出来
    private HashSet<Question> questionBox = new HashSet<>();

    {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src//dbfile//Question.txt"));
            String message = reader.readLine();//每一次读取一行  title#answer
            while(message!=null){
                String[] values = message.split("#");
                questionBox.add(new Question(values[0],values[1]));
                message = reader.readLine();
            }
            reader.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public HashSet<Question> getQuestionBox(){
        return questionBox;
    }
}
