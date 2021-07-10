package testmain;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class Test5 {

    public static void main(String[] args) throws Exception {

        Properties pro = new Properties();
        pro.load(Test5.class.getClassLoader().getResourceAsStream("druid.properties"));
        DataSource ds = DruidDataSourceFactory.createDataSource(pro);
        Connection conn = ds.getConnection();
        String sql = "select * from emp";
        PreparedStatement pre = conn.prepareStatement(sql);
        ResultSet set = pre.executeQuery();
        while (set.next()){
            int empno = set.getInt("empno");
            String ename = set.getString("ename");
            String job = set.getString("job");
            int mgr = set.getInt("mgr");
            Date hiredate = set.getDate("hiredate");
            float sal = set.getFloat("sal");
            float comm = set.getFloat("comm");
            int deptno = set.getInt("deptno");
            System.out.println(empno+""+ename+""+job+mgr+hiredate+sal+comm+deptno);
        }
    }
}
