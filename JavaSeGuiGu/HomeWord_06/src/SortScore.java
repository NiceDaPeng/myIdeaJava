import java.util.Scanner;

public class SortScore {

    public static void main(String[] args) {

        //案例：从键盘输入本组学员的人数，和本组学员的成绩，用数组存储成绩，然后实现从高到低排序

        Scanner input = new Scanner(System.in);
        System.out.println("请输入学员的人数");
        int num = input.nextInt();
        int[] score = new int[num];

        for (int i= 0; i < num; i++){
            System.out.println("请输入第"+(i+1)+"个学生的成绩");
            score[i] = input.nextInt();
        }

        for (int i= 1; i < score.length;i++){
            for (int j = 0; j < score.length - i;j++){
                if (score[j] < score[j+1]){
                    int temp = score[j];
                    score[j] = score[j+1];
                    score[j+1] = temp;
                }
            }
        }
        for (int value :
                score) {
            System.out.println(value);
        }
    }
}
