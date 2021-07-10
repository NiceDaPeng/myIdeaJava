package testutil;

public class TestString {

    public static void main(String[] args) {

//        String str = "dpj.java";
//
//        boolean flag = str.startsWith("a");
//        System.out.println(flag);
//
//        boolean temp = str.endsWith("a");
//        System.out.println(temp);
//
//        String string = "你个傻逼";
//        //String replace = string.replace("帅", "good");
//        //System.out.println(replace);
//
//        String string2 = string.replaceAll("傻逼", "***");
//        System.out.println(string2);
//
//        String str1 = "a-b-c-d";
//        String[] split = str1.split("-");//按照“-”进行拆分
//
//        String[] split1 = str1.split("-", 3);//按照“-”将字符串拆分成3段，每一个“-”表示一段。
//
//        for (String value : split){
//            System.out.println(value);
//        }
//        for (String value : split1){
//            System.out.println(value);
//        }

        String str = "abcdef";
        String substring = str.substring(0, 3);
        System.out.println(substring);
    }
}
