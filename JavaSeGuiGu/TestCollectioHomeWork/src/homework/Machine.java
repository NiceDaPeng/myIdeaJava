package homework;

import java.util.*;

public class Machine {

    private static HashSet<QuentionsBank> base = new HashSet<>();
    private static HashMap<String, String> stuMes = new HashMap<String, String>();
    private ArrayList<QuentionsBank> stuQuestions = new ArrayList<QuentionsBank>();

    static {

        base.add(new QuentionsBank("以下哪个选项不是Java的基本类型?\n\tA,short\n\tB,boolean\n\tC,String\n\tD,char\n","String"));
        base.add(new QuentionsBank("以下哪个选项是Java的基本类型?\n\tA.Short\n\tB.Boolean\n\tC.String\n\tD.char\n","D"));
        base.add(new QuentionsBank("以下哪个是引用数据类型？\n\tA,short\n\tB,byte\n\tC,int\n\tD,String\n","D"));
        base.add(new QuentionsBank("HTML指的是？\n\tA,超文本标记语言\n\tB,家庭工具标记语言\n\tC,超链接语言\n\tD,以上度正确","A"));
        base.add(new QuentionsBank("以下哪个是java.lang包下的类\n\tA,String\n\tB,Scanner\n\tC,Date\n\tD,BigInteger","A"));
        base.add(new QuentionsBank("以下选项哪个不是java.util包中的类?\n\tA.Date\n\tB.Integer\n\tC.Calendar\n\tD.Random","B"));
        base.add(new QuentionsBank("以下选项哪个不是String类中的方法?\n\tA.compareTo\n\tB.append\n\tC.substring\n\tD.concat","B"));
        base.add(new QuentionsBank("以下选项哪个是Str ing类中方法?\n\tA.append\n\tB.delete\n\tC.insert\n\tD.concat","D"));
        base.add(new QuentionsBank("以下选项哪个不是接口中属性的修饰符?\n\tA.public\n\tB.static\n\tC.final\n\tD.abstract","D"));
        base.add(new QuentionsBank("以下选项哪个不是Set集合的方法?\n\tA.set\n\tB.add\n\tC.remove\n\tD.iterator","A"));

        stuMes.put("张三", "1234");
        stuMes.put("李四", "1234");
        stuMes.put("王五", "1234");
    }

    public void welcome(Student student) {

        Scanner input = new Scanner(System.in);
        System.out.println("您好,祝您考试成功");
        String userName = "";

        while (true) {

            System.out.print("请输入账号：");
            String name = input.nextLine();
            System.out.print("请输入密码：");
            String password = input.nextLine();
            boolean range = range(name, password);

            if (range == false) {
                System.out.println("登录失败，请重新输入");
            } else {
                System.out.println("登录成功");
                userName = name;
                System.out.println("正在生成试卷，请稍后");
                try {
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;
            }
        }

        begin(userName);
    }

    public void begin(String userName) {

        System.out.println("请认真审题后作答，题目如下");
        Scanner input = new Scanner(System.in);
        String[] answers = new String[base.size()];

        int k = 0;
        Iterator<QuentionsBank> iterator = base.iterator();

        while (iterator.hasNext() && k < 5){

            stuQuestions.add(iterator.next());
            System.out.println(k+1 +","+iterator.next().getTitle());
            System.out.println("--请输入您的答案--：");
            String answer = input.nextLine();
            answers[k++] = answer;
        }
        System.out.println("老师正在改卷，请稍后");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        int offset = 0;
        for (int i = 0; i < stuQuestions.size();i++){
            if((stuQuestions.get(i).getAnswer()).equals(answers[i])){
                offset += (100 / stuQuestions.size());
            }
        }

        System.out.println("分数"+offset);
    }

    //设计一个方法用来登录提示


    //设计一个方法用来对账号密码进行判断
    public boolean range(String name, String password) {

        if (stuMes.containsKey(name)) {
            if (name != null && stuMes.get(name).equals(password)) {
                return true;
            }
        }
        return false;
    }

}
