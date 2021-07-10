package testutil;

public class StringExceprise {

    //设计一个方法将字符串反转

    public String reverseString(String str){

        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length /2; i++){
            char temp = chars[i];
            chars[i] = chars[chars.length- 1 -i];
            chars[chars.length- 1 -i] = temp;
        }

        return new String(chars);


    }

    //设计一个方法 将给定的字符串的正序和反序拼接

    public String concatString(String str){

        str = str.concat(this.reverseString(str));
        return str;
    }

    //设计一个方法判断字符串是否为回文字符串
    public boolean rangeStringIsReturnString(String str){
        //hhelhjejyh
      return  this.reverseString(str).equals(str);
    }

    //设计一个方法将给定的字符串左移X位置 helloworld-->ldhellowor

    public String moveString(String str,int offset){
        if (offset >= str.length()){
            offset %= str.length();
        }
        String end = str.substring(0, str.length() - offset);
        String begin = str.substring(str.length() - offset);
        return begin.concat(end);
    }

    //设计一个方法寻找若干字符串中最常的那个字符串
    public String getMaxLengthString(String str1,String str2,String str3){
        if (str1.length() > str2.length() && str1.length() > str3.length()){
            return str1;
        }else if (str2.length() > str1.length() && str2.length() > str3.length()){
            return str2;
        }else {
            return str3;
        }
    }

    //设计一个方法，统计给定字母在字符串中出现的次数
    public int getFreQuency(String str,char value){

        int time = 0;
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++){
            if (value == chars[i]){
                time++;
            }
        }
        return time;
    }

    //设计一个方法将给定的字符串的每个首字母大写
    public String StringToUpperCase(String str){
        //i am a good man
        String[] split = str.split(" ");
        String temp = "";

        for (int i = 0; i < split.length;i++){

            String frist = (split[i].charAt(0) + "").toUpperCase();
            String concat = frist.concat(split[i].substring(1));
            temp += concat + " ";

        }
        return temp;
    }

    //设计一个方法获取给定字符串的全部数字
    public int  getNumber(String str){
        String string = "";
        if (str.isEmpty()){
            return 0;
        }
        for (int i = 0; i < str.length(); i++){
            int value = str.codePointAt(i);
            string += (char)value;
        }

        return Integer.parseInt(string);
    }
}
