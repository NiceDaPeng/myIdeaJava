package acountbooktest;

import java.util.Scanner;

public class TestMain {

    public static void main(String[] args) {
        int money = 10000;
        boolean flag = true;
        String details = "收支\t账户金额\t收支金额\t说    明\n";

        while (flag){
            System.out.println("-----------------家庭收支记账软件-----------------");
            System.out.println();
            System.out.println("\t\t\t\t\t1收支明细");
            System.out.println("\t\t\t\t\t2登记收入");
            System.out.println("\t\t\t\t\t3登记支出");
            System.out.println("\t\t\t\t\t4退   出");
            Scanner input = new Scanner(System.in);
            System.out.print("\t\t\t\t\t请选择1-4:");
            int select = Integer.parseInt(input.nextLine());

            switch (select) {
                case 1:
                    System.out.println("-----------------当前收支明细记录-----------------\n");
                    System.out.println();
                    System.out.println(details);

                    break;
                case 2:
                    System.out.print("本次收入金额：");
                    String inMoney = input.nextLine();
                    System.out.print("本次收入说明:");
                    String introduce = input.nextLine();
                    money += Integer.parseInt(inMoney);
                    details += "收入\t"+Integer.parseInt(inMoney) +"\t"+ money + "\t"+introduce+"\n";
                    break;
                case 3:
                    System.out.print("本次支出金额：");
                    String outMoney = input.nextLine();
                    System.out.print("本次支出说明：");
                    String outIntroduce = input.nextLine();
                    money -= Integer.parseInt(outMoney);
                    details += "收入\t"+Integer.parseInt(outMoney) +"\t"+ money + "\t"+outIntroduce+"\n";
                    break;
                case 4:

                    System.out.println("确认退出吗？Y/N");
                    char charAt = input.next().charAt(0);
                    if (charAt == 'Y' || charAt == 'y'){
                        flag = false;
                    }
                    break;
            }
        }

    }
}
