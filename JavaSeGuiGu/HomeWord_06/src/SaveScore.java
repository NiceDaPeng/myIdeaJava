import java.util.Scanner;

public class SaveScore {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("请输入总共的组数");
        int group = input.nextInt();
        System.out.println("请输入每个组数中的学生的个数");
        int num = input.nextInt();


        System.out.println("班级内的总人数为："+(group * num));

        int[][] stu = new int[group][num];
        for (int i = 0 ; i < stu.length;i++){
            int avgGroup = 0;
            int sum = 0;
            int max = 0;
            int min = 0;
            int avg = 0;
            int count = 0;
            for (int j = 0; j < stu[i].length;j++){
                System.out.println("请输入第"+(i+1)+"组第"+(j+1)+"个学生的成绩");
                 int value = input.nextInt();
                stu[i][j] = value;
                sum += value;
                System.out.println("本组的总分为："+(stu[i][j]+stu[i][j+1]));
                System.out.println("本组的平均分为："+(stu[i][j]+stu[i][j+1])/stu[i].length);
                System.out.println("本组的最大值为："+(stu[i][j] > stu[i][j+1]?stu[i][j]:stu[i][j+1]));
                System.out.println("本组的最小值为："+(stu[i][j] < stu[i][j+1]?stu[i][j]:stu[i][j+1]));


            }


        }






    }
}
