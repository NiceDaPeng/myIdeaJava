package homeworkDemo;

import java.util.ArrayList;
import java.util.Scanner;

public class Student {

    private String username;
    private String password;

    public Student(String username,String password){
        this.username = username;
        this.password = password;
    }

    public String getUsername(){
        return this.username;
    }

    public String getPassword(){
        return this.password;
    }

    public String[] exam(ArrayList<Question> paper){
        String[] answers = new String[paper.size()];
        Scanner input = new Scanner(System.in);
        for (int i = 0; i < paper.size();i++){
            Question question = paper.get(i);
            System.out.println(i+1+"."+question.getTitle());
            System.out.println("请输入您认为正确的选项：");
            answers[i] = input.nextLine();
        }
        return answers;
    }
}
