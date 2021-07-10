package testutil;

public class TestMain {

    public static void main(String[] args) {

        StringExceprise se = new StringExceprise();
        String string = se.reverseString("hello");
        System.out.println(string);

        String string1 = se.concatString("nice");
        System.out.println(string1);

        boolean heel = se.rangeStringIsReturnString("heeeh");
        System.out.println(heel);

        int time = se.getFreQuency("hellooooohahah", 'o');
        System.out.println('a'+"出现的次数为："+time+"次");

        String string2 = se.StringToUpperCase("i am a good man");
        System.out.println(string2);

        se.getNumber("1sd32dsrg9asd923");
        String string3 = se.moveString("helloword", 3);
        System.out.println(string3);
    }
}
