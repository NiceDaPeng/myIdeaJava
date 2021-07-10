package homework;

import jdbcutil.JDBCUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class Test02 {
    private static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        showMes();
    }

    public static void showMes(){
        System.out.println("请输入老师的工号：");
        String number = input.nextLine();
        Connection conn = JDBCUtil.getConn();

        try {
            String sql = "select * from teacher where number = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,Integer.parseInt(number));
            ResultSet set = pre.executeQuery();
            while (set.next()){
                System.out.println(set.getObject(1)+"-"+set.getObject(2)+"-"+set.getObject(3));
            }
            JDBCUtil.free(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
