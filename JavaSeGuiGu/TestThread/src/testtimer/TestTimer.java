package testtimer;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class TestTimer {
    private int count  =1;

    ArrayList<String> list = new ArrayList<>();
    {
        for (int i = 0; i < 5;i++)
        list.add("a"+i);
    }

    public static void main(String[] args) {
        TestTimer tt = new TestTimer();
        try {
            tt.testTimer();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

    //设计一个方法用来固定的时间给一个人发送一条垃圾短信

    public void testTimer() throws ParseException {
        Timer timer = new Timer();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = sdf.parse("2021-04-05 12:25:00");

        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println("第"+count+++"次发送");
                for (int i = 0; i < list.size();i++){

                    System.out.println("给"+list.get(i)+"发送了一条垃圾短息：【就是玩一玩而已]");
                }
            }
        },date,3000);
    }
}
