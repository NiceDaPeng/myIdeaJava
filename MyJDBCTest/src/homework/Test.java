package homework;

import jdbcutil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class Test {

    public static void main(String[] args) {
        //修改指定工号的老师的工资为指定工资
        Connection conn = JDBCUtil.getConn();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入您要修改薪资的老师编号");
        String number = input.nextLine();
        System.out.println("修改后的薪资为：");
        String salary = input.nextLine();
        String sql = "update teacher set salary = ? where number = ?";
        PreparedStatement pre = null;
        try {
            pre = conn.prepareStatement(sql);
            pre.setFloat(1, Float.parseFloat(salary));
            pre.setInt(2, Integer.parseInt(number));
            int num = pre.executeUpdate();
            System.out.println(num>0?"修改成功":"修改失败");
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
