package day2102;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Student> list = new ArrayList<>();
        while (true) {
            System.out.println("请输入您的选择：1表示继续录入；2表示结束录入");
            String inValue = input.nextLine();
            int check = Integer.parseInt(inValue);
            if (check == 1){
                System.out.println("请输入姓名");
                String name = input.nextLine();
                System.out.println("请输入年龄");
                String ageValue = input.nextLine();
                int age = Integer.parseInt(ageValue);
                Student stu = new Student(name,age);
                list.add(stu);
            } else if (check == 2){
                break;
            } else if (check == 3){
                for (Student stu :
                        list) {
                    System.out.println(stu.getName()+"-"+stu.getAge());
                }
            } else {
                System.out.println("您的输入有误请重新输入");
            }
        }
    }
}
