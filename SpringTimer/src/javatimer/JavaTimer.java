package javatimer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class JavaTimer {

    //模拟一个定时器效果，每天晚上固定时间发送一个消息
    public static void main(String[] args) throws ParseException {

        System.out.println("准备发送消息了");
        //用来存储用户的名字，手机号，邮箱等
        String[] userArray = {"a","b","c","d","e"};
        ArrayList<String> userList = new ArrayList<String>(Arrays.asList(userArray));
        //每天凌晨两点发送信息给集合中的用户
        SimpleDateFormat ds = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
        Date firstTime = ds.parse("2021-6-19 15:46:00");//date是格林威治的时间
        //找一个计时器对象，帮我们倒计时，时间到了就做事情
        Timer timer = new Timer();
        //让timer帮我们做事情 ,task是任务是个抽象类，date是时间
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                for (String str:userList) {
                    System.out.println("hello"+str+"，我执行了[你现在看到的是垃圾信息]");
                }
            }
        },firstTime,3000);
//        System.out.println(date);
//        String format = ds.format(new Date());
//        System.out.println(format);
    }
}
