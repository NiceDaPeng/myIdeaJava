package util;

import bean.Question;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class QuestionFileReader {

    private HashSet<Question> questionHashSet = new HashSet<>();
    {
        try {
            BufferedReader br = new BufferedReader(new FileReader("src/dbfile/Question.txt"));
            String question;
            while ((question = br.readLine()) != null){
                String[] values = question.split("#");
                if (values.length == 2){
                    questionHashSet.add(new Question(values[0],values[1]));
                }else {
                    questionHashSet.add(new Question(values[0],values[1],values[2]));
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public HashSet<Question> getQuestionHashSet(){
        return this.questionHashSet;
    }
}
