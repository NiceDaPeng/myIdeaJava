package test;

import dao.DruidDao;
import domian.Dept;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class TestMain {

    public static void main(String[] args) throws SQLException {
//        String sql = "select * from dept";
//        List<Dept> depts = DruidDao.selectMore(sql);
//        for (Dept d :
//                depts) {
//            System.out.println(d);
//        }
//        System.out.println("------------------");
//        String sql1 = "select * from dept where deptno=10";
//        Dept dept = DruidDao.selectOne(sql1);
//        System.out.println(dept);

        Connection conn = DruidDao.getConn();
        QueryRunner qr = new QueryRunner();
//        String sql = "select * from dept";
//        List<Dept> query = qr.query(conn, sql, new BeanListHandler<>(Dept.class));
//        for (Dept dept :
//                query) {
//            System.out.println(dept);
//        }
//        String sql = "select * from dept where deptno=?";
//        Dept query = qr.query(conn, sql, new BeanHandler<>(Dept.class), 10);
//        System.out.println(query);

//        String sql = "update dept set deptno=? where deptno=?";
//        int update = qr.update(conn, sql, 66, 10);
//        System.out.println(update>0?"success":"faiure");

        String sql = "select count(*) from dept";
        Object query = qr.query(conn, sql, new ScalarHandler<>());
        System.out.println(query);

    }
}
