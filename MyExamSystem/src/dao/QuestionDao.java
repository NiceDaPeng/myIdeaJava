package dao;

import bean.Question;
import util.MySpring;
import util.QuestionFileReader;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class QuestionDao {

   private QuestionFileReader questionFileReader = MySpring.getBean("util.QuestionFileReader");

   private ArrayList<Question> list = new ArrayList<>(questionFileReader.getQuestionHashSet());

   public ArrayList<Question> getPaper(int count){
       HashSet<Question> paper = new HashSet<>();
       while (paper.size() != count){
           Random ran = new Random();
           int index = ran.nextInt(this.list.size());
           paper.add(list.get(index));
       }
       return new ArrayList<Question>(paper);
   }
}
