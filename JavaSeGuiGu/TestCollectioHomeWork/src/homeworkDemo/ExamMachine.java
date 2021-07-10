package homeworkDemo;

import java.util.*;

public class ExamMachine {


    private HashMap<String,String> userBox = new HashMap<String,String>();

    {
        userBox.put("张三", "1234");
        userBox.put("李四", "1234");
        userBox.put("王五", "1234");
    }

    private HashSet<Question> questionBank = new HashSet<Question>();
    {
        questionBank.add(new Question("以下选项哪个是Java基本数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个不是Java基本数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.double","A"));
        questionBank.add(new Question("以下选项哪个是Java引用数据类型?\n\tA.String\n\tB.int\n\tC.boolean\n\tD.char","A"));
        questionBank.add(new Question("以下选项哪个不是Java引用数据类型?\n\tA.String\n\tB.Integer\n\tC.boolean\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个是java.util包中的类?\n\tA.String\n\tB.Integer\n\tC.Scanner\n\tD.Math","C"));
        questionBank.add(new Question("以下选项哪个不是java.util包中的类?\n\tA.Date\n\tB.Integer\n\tC.Calendar\n\tD.Random","B"));
        questionBank.add(new Question("以下选项哪个不是String类中的方法?\n\tA.compareTo\n\tB.append\n\tC.substring\n\tD.concat","B"));
        questionBank.add(new Question("以下选项哪个是String类中方法?\n\tA.append\n\tB.delete\n\tC.insert\n\tD.concat","D"));
        questionBank.add(new Question("以下选项哪个不是接口中属性的修饰符?\n\tA.public\n\tB.static\n\tC.final\n\tD.abstract","D"));
        questionBank.add(new Question("以下选项哪个不是Set集合的方法?\n\tA.set\n\tB.add\n\tC.remove\n\tD.iterator","A"));
    }

    //设计一个方法 生成随机的五道题
    public ArrayList<Question> getPaper(){
        System.out.println("试卷正在生成中，请稍等");
        try {
            Thread.sleep(1000);
        }catch(Exception e){
            e.printStackTrace();
        }
        HashSet<Question> paper = new HashSet<Question>();
        ArrayList<Question> questionBank = new ArrayList<Question>(this.questionBank);

        while(paper.size() != 5){
            int index = new Random().nextInt(this.questionBank.size());
            paper.add(questionBank.get(index));
        }

        return new ArrayList<Question>(paper);

    }

    //考试机中还有一个登录方法


        public String login(String username,String password){
            String realPassword = this.userBox.get(username);
            if(realPassword!=null && realPassword.equals(password)){
                return "登录成功";
            }
            return "用户名或密码错误";
        }

}
