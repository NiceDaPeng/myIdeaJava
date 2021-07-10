package jdbcutil2;

import jdbcutil.JDBCUtil;
import jdbcutil2.JDBCUtils2;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {

        Connection conn = JDBCUtils2.getConn();
        try {
            conn.setAutoCommit(false);
            String sql1 = "update department set depNote='啥都干' where depNo=601";
            String sql2 = "update department set depNote='跟601一样' where depNo=602";
            try{
                int len1 = JDBCUtils2.update(sql1);
                int len2 = JDBCUtils2.update(sql2);
                if (len1 > 0 && len2 > 0){
                    conn.commit();
                } else {
                    conn.rollback();
                }
            } catch (Exception e){
                conn.rollback();
            }
            conn.setAutoCommit(true);
            JDBCUtil.free(conn);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
