package dao;

import com.alibaba.druid.pool.DruidDataSourceFactory;
import domian.Dept;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class DruidDao {
    private static Connection conn;
    private static DataSource dataSource;
    static {
        Properties pro = new Properties();
        try {
            pro.load(DruidDao.class.getClassLoader().getResourceAsStream("druid.properties"));
            dataSource = DruidDataSourceFactory.createDataSource(pro);
            conn = dataSource.getConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    public static Connection getConn(){
        return conn;
    }

    /**
     * 查询一个部门的信息
     * @param sql 要执行的sql语句
     * @param args 动态参数
     * @return 如果返回null则表示没有查询到数据 否则返回是对象信息
     * @throws SQLException
     */
    public static Dept selectOne(String sql,Object... args) throws SQLException {
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);
            }
            ResultSet resultSet = pre.executeQuery();
            if (resultSet.next()){

                int deptno = resultSet.getInt("deptno");
                String dname = resultSet.getString("dname");
                String loc = resultSet.getString("loc");
                Dept dept = new Dept(deptno,dname,loc);
                return dept;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }

    /**
     * 用来查询多条记录的方法
     * @param sql
     * @param args
     * @return
     */
    public static List<Dept> selectMore(String sql,Object... args){
        List<Dept> list = new ArrayList<>();
        try {
            PreparedStatement pre = conn.prepareStatement(sql);
            for (int i = 0; i < args.length; i++) {
                pre.setObject(i+1,args[i]);
            }
            ResultSet resultSet = pre.executeQuery();
            while (resultSet.next()){
                Dept dept = new Dept();
                dept.setDeptno(resultSet.getInt("deptno"));
                dept.setDname(resultSet.getString("dname"));
                dept.setLoc(resultSet.getString("loc"));
                list.add(dept);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    public static void close(ResultSet set, Statement statement,Connection conn){
        try {
            if (set != null){
                set.close();
            }
            if (statement != null){
                statement.close();
            }
            if (conn != null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
