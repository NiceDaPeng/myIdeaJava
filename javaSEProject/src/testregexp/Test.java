package testregexp;

import java.util.regex.Pattern;

public class Test {
    public static void main(String[] args) {
        String reg="\\w{6,}@";
        String name="wddssa@";
        System.out.println(name.matches(reg));
        int i=10;
        i=i++;
        System.out.println(i);
    }
}
