package day2101;

import java.util.ArrayList;
import java.util.Random;


public class Test01 {
/*
    随机验证码。

* 随机生成十组六位字符组成的验证码。
* 验证码由大小写字母、数字字符组成。
 */
    public static void main(String[] args) {
        //将26个英文字母的大小写全部放在char数组中，然后将数字放在其中
        char[] letters = new char[26+26+10];
        for (int i = 0; i < letters.length;i++){
            if (i < 10){//前10个方式数字
                letters[i] = (char) (i+48);
            }else if (i < 26+10){//中间放26个大写字母
                letters[i] = (char)(i+65-10);
            }else if (i < 26+10+26){//放小写字母
                letters[i] = (char)(i+97-26-10);
            }
        }
        Random ran = new Random();
        ArrayList<String> list = new ArrayList<>();
        for (int i= 0; i < 10; i++){
            char[] arr = new char[6];
            for (int j = 0; j < arr.length;j++){
                arr[j] = letters[ran.nextInt(letters.length)];
            }
            String value = new String(arr);
            list.add(value);
        }
        for (String value :
                list) {
            System.out.println(value);
        }
    }
}
