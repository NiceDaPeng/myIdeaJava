package testmain;

import Service.QuestionService;
import domain.Question;
import util.MySpring;
import view.LoginFrame;

import java.util.ArrayList;

public class TestMain {
    public static void main(String[] args) {
        new LoginFrame("登录窗口");

        //一道题目  两个部分  题干(问题+选项)  答案
        //  题干--->String   答案--->String
        //  数组String[2]  value[0] value[1]  集合
        //  字符串 题干#答案  对象(题干 答案)

        QuestionService service = MySpring.getBean("Service.QuestionService");
        ArrayList<Question> paper = service.getPaper(5);

        //在控制台打印测试里面的题目。
//        for(int i=0;i<paper.size();i++){
//            Question question = paper.get(i);
//            String title = question.getTitle().replace("<br>","\n   ");
//            System.out.println((i+1)+"."+title);
//        }
    }
}
