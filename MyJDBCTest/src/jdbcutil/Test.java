package jdbcutil;

import java.sql.Connection;
import java.sql.SQLException;

public class Test {

    public static void main(String[] args) {

        Test t = new Test();
        try {
            t.updateData();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    public void updateData() throws SQLException {
        Connection conn = JDBCUtil.getConn();
        conn.setAutoCommit(false);

        try {
            String sql1 = "update department set depNote=? where depNo=?";
            String sql2 = "update department set depNote=? where depNo=?";
            int len1 = JDBCUtil.update(conn, sql1, "管理电脑的",601 );
            int len2 = JDBCUtil.update(conn, sql2, "修理电脑的",602);
            if (len1 > 0 && len2 > 0) {
                conn.commit();
            } else {
                conn.rollback();
            }
        } catch (Exception e) {
            conn.rollback();
        }
        JDBCUtil.free(conn);

    }
}
