import java.util.Scanner;

public class FindIndex {

    public static void main(String[] args) {

        boolean flag = false;

        Scanner input = new Scanner(System.in);
        System.out.println("请输入本组学员的人数");
        String numStr = input.nextLine();
        int num = Integer.parseInt(numStr);

        String[] student = new String[num];

        for (int i = 0; i < student.length;i++){
            System.out.println("请输入第"+(i+1)+"个同学的姓名");
            String name = input.nextLine();
            student[i] = name;
        }

        System.out.println("请输入你要查找的人员的姓名");
        String name = input.nextLine();

        for (int i = 0; i < student.length; i++){
            if (student[i].equals(name)){
                System.out.println("您要查找的学生的下标为："+i);
                flag = true;
            }
        }
        if (!flag)
        System.out.println("你要查找的姓名不存在");
    }
}
