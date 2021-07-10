package testutil;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TestRegularExcpression {

    public static void main(String[] args) {

        String str = "12345589";
        boolean matches = str.matches("[0-9]{2,}");
        System.out.println(matches);

        String string = "123456abc654321def123456ghi";

        //利用Pattern类创建一个模式，理解为是一个正则表达式对象
        Pattern pattern = Pattern.compile("\\d{6}");

        //提供一个字符串，利用Pattern模式对象创建一个匹配器
        Matcher matcher = pattern.matcher(string);

        //找寻字符串中符合模式的子串
        while(matcher.find()){
            //找到满足字符串格式的那一串文字
            System.out.println(matcher.group());
        }

    }
}
