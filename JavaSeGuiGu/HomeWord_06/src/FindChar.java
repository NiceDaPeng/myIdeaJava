import java.util.Scanner;

public class FindChar {

    public static void main(String[] args) {

        boolean flag = false;

        Scanner input = new Scanner(System.in);

        System.out.println("请输入一个英语单词");
        String english = input.nextLine();

        char[] chars = english.toCharArray();

        System.out.println("请输入你要查找的字母");
        char value = input.next().charAt(0);
        for (int i = 0; i < chars.length; i++){
            if (chars[i] == value){
                flag = true;
                System.out.println(true);
                break;
            }
        }
        if (!flag){
            System.out.println("不存在");
        }
    }
}
