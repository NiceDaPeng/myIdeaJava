package homeworkDemo;

import java.util.ArrayList;

public class Teacher {

    public int checkPaper(ArrayList<Question> paper,String[] answers){
        System.out.println("老师正在改卷，请稍后");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int score = 0;
        for (int i = 0; i < paper.size();i++){
            Question question = paper.get(i);
            if (question.getAnswer().equals(answers[i])){
                score += (100/paper.size());
            }
        }
        return score;
    }
}
