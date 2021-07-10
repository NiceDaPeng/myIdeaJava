package com.testenum.dpj;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class TestEnum {

    public static void main(String[] args) {

        int i = Test.MONDAY.compareTo(Test.THRIDAY);
        System.out.println(i);

        Random ran = new Random();
        int value = ran.nextInt(10);
        System.out.println(value);

        double random = Math.random();
        System.out.println(random);

        BigDecimal bd = new BigDecimal("123.456");
        BigDecimal bigDecimal = bd.setScale(2, BigDecimal.ROUND_CEILING);
        System.out.println(bigDecimal);

        DecimalFormat df = new DecimalFormat("000.###");
        String format = df.format(123.4456);
        System.out.println(format);

        Date date = new Date();
        System.out.println(date);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd:HH-mm-ss");
        String format1 = sdf.format(date);
        System.out.println(format1);

        Date date1 = new Date();
        boolean before = date1.before(date);
        System.out.println(before);

        boolean after = date1.after(date);
        System.out.println(after);

        date.setTime(12323333445L);
        System.out.println(date);
        String format2 = sdf.format(date);
        System.out.println(format2);

        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        int i1 = instance.get(Calendar.DAY_OF_WEEK_IN_MONTH);
        int i2 = instance.get(Calendar.DAY_OF_YEAR);
        System.out.println(i1);
        instance.get(Calendar.YEAR);



    }

    public static synchronized void testThread(){
        System.out.println("wahaha");
    }
}
